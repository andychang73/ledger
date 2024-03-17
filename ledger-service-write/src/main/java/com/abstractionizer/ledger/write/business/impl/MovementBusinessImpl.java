package com.abstractionizer.ledger.write.business.impl;

import com.abstractionizer.ledger.write.business.MovementBusiness;
import com.abstractionizer.ledger.write.business.WalletBusiness;
import com.abstractionizer.ledger.write.model.dto.MovementBroadCastDto;
import com.abstractionizer.ledger.write.model.dto.MovementMoveDto;
import com.abstractionizer.ledger.write.model.dto.WalletDetailAndHistoryUpdateDto;
import com.abstractionizer.ledger.write.model.dto.WalletDetailUpdateDto;
import com.abstractionizer.ledger.write.model.vo.SimpleWalletVo;
import com.abstractionizer.ledger.write.service.MovementService;
import com.abstractionizer.ledger.write.service.WalletService;
import com.abstractionizer.ledger.write.storage.rmdb.entity.MovementEntity;
import com.abstractionizer.module.enumeration.MovementState;
import com.abstractionizer.module.exception.DeclineException;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static com.abstractionizer.ledger.write.mq.rabbit.config.MovementConfig.MOVEMENT_BROADCAST_EXCHANGE;
import static com.abstractionizer.ledger.write.mq.rabbit.config.WalletConfig.WALLET_BALANCE_UPDATE_EXCHANGE;

@Slf4j
@Service
public class MovementBusinessImpl implements MovementBusiness {

    private final RabbitTemplate rabbitTemplate;
    private final MovementService movementService;
    private final WalletBusiness walletBusiness;
    private final WalletService walletService;

    public MovementBusinessImpl(RabbitTemplate rabbitTemplate, MovementService movementService,
                                WalletBusiness walletBusiness, WalletService walletService) {
        this.rabbitTemplate = rabbitTemplate;
        this.movementService = movementService;
        this.walletBusiness = walletBusiness;
        this.walletService = walletService;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void move(@NotNull final MovementMoveDto dto) {

        MovementEntity movement = movementService.getMovementEntity(dto, MovementState.PENDING);
        movementService.insert(movement);
        rabbitTemplate.convertAndSend(MOVEMENT_BROADCAST_EXCHANGE, "", new MovementBroadCastDto(movement));

        try {

            WalletDetailUpdateDto walletDetailUpdateDto = walletBusiness.validateMovementDto(dto);

            walletBusiness.transferToTargetWallet(dto.getSourceWalletId(), dto.getTargetWalletId(), dto.getAmount());

            updateMovementState(movement, MovementState.CLEARED, LocalDateTime.now());
            SimpleWalletVo sourceWallet = walletService.getWalletVoOrThrow(walletDetailUpdateDto.getSourceWalletId());
            SimpleWalletVo targetWallet = walletService.getWalletVoOrThrow(walletDetailUpdateDto.getTargetWalletId());

            WalletDetailAndHistoryUpdateDto updateDetail = WalletDetailAndHistoryUpdateDto.builder()
                    .entityId(dto.getEntityId())
                    .sourceAccountId(walletDetailUpdateDto.getSourceAccountId())
                    .targetAccountId(walletDetailUpdateDto.getTargetAccountId())
                    .assetType(walletDetailUpdateDto.getAssetType())
                    .assetCode(walletDetailUpdateDto.getAssetCode())
                    .assetName(walletDetailUpdateDto.getAssetName())
                    .sourceWalletId(sourceWallet.getId())
                    .sourceBalance(sourceWallet.getBalance())
                    .targetWalletId(targetWallet.getId())
                    .targetBalance(targetWallet.getBalance())
                    .amount(walletDetailUpdateDto.getAmount())
                    .build();

            rabbitTemplate.convertAndSend(WALLET_BALANCE_UPDATE_EXCHANGE, "", sourceWallet);
            rabbitTemplate.convertAndSend(WALLET_BALANCE_UPDATE_EXCHANGE, "", targetWallet);
            rabbitTemplate.convertAndSend(MOVEMENT_BROADCAST_EXCHANGE, "", new MovementBroadCastDto(movement));
            rabbitTemplate.convertAndSend("", "ledger.read.balance.history.update.q", updateDetail);

        } catch (DeclineException dex) {

            MovementEntity declinedMovement = updateMovementStateRequiresNew(movement, MovementState.DECLINED, LocalDateTime.now());

            rabbitTemplate.convertAndSend(MOVEMENT_BROADCAST_EXCHANGE, "", new MovementBroadCastDto(declinedMovement, dex.getMessage()));

            throw dex;

        } catch (Exception ex){

            MovementEntity failedMovement = updateMovementStateRequiresNew(movement, MovementState.FAILED, LocalDateTime.now());

            rabbitTemplate.convertAndSend(MOVEMENT_BROADCAST_EXCHANGE, "", new MovementBroadCastDto(failedMovement, ex.getMessage()));

            throw ex;
        }

    }

    private void updateMovementState(MovementEntity movement, MovementState state, LocalDateTime modifiedAt){
        movement.setState(state);
        movement.setModifiedAt(modifiedAt);
        movementService.updateEntity(movement);
    }

    private MovementEntity updateMovementStateRequiresNew(MovementEntity movement, MovementState state, LocalDateTime modifiedAt){
        movement.setState(state);
        movement.setModifiedAt(modifiedAt);
        movementService.updateEntityRequiresNew(movement);
        return movement;
    }
}
