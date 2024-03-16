package com.abstractionizer.ledger.write.business.impl;

import com.abstractionizer.ledger.write.business.MovementBusiness;
import com.abstractionizer.ledger.write.model.dto.MovementBroadCastDto;
import com.abstractionizer.ledger.write.model.dto.MovementMoveDto;
import com.abstractionizer.ledger.write.model.dto.WalletBalanceUpdateDto;
import com.abstractionizer.ledger.write.model.vo.AccountVo;
import com.abstractionizer.ledger.write.model.vo.WalletVo;
import com.abstractionizer.ledger.write.service.AccountService;
import com.abstractionizer.ledger.write.service.EntityService;
import com.abstractionizer.ledger.write.service.MovementService;
import com.abstractionizer.ledger.write.service.WalletService;
import com.abstractionizer.ledger.write.storage.rmdb.entity.MovementEntity;
import com.abstractionizer.module.enumeration.MovementState;
import com.abstractionizer.module.exception.BusinessException;
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
    private final EntityService entityService;
    private final AccountService accountService;
    private final WalletService walletService;
    private final MovementService movementService;

    public MovementBusinessImpl(RabbitTemplate rabbitTemplate, EntityService entityService,
                                AccountService accountService, WalletService walletService,
                                MovementService movementService) {
        this.rabbitTemplate = rabbitTemplate;
        this.entityService = entityService;
        this.accountService = accountService;
        this.walletService = walletService;
        this.movementService = movementService;
    }

    @Transactional
    @Override
    public void move(@NotNull final MovementMoveDto dto) {

        Long movementId = null;
        AccountVo sourceAccount;
        try {
            sourceAccount = entityService.getAccountOrThrow(dto.getEntityId(), dto.getSourceAccountId());
            accountService.validateAccountStateIsOpen(sourceAccount.getAccountState());

            AccountVo targetAccount = entityService.getAccountOrThrow(dto.getEntityId(), dto.getSourceAccountId());
            accountService.validateAccountStateIsOpen(targetAccount.getAccountState());

            WalletVo sourceWallet = accountService.getWalletOrThrow(sourceAccount.getId(), dto.getSourceWalletId());
            WalletVo targetWallet = accountService.getWalletOrThrow(targetAccount.getId(), dto.getTargetWalletId());
            walletService.checkIfBothAssetTypeAreSameOrThrow(sourceWallet.getAssetType(), targetWallet.getAssetType());

            walletService.checkIfSufficientFundOrThrow(sourceWallet.getBalance(), sourceWallet.getFreezeBalance(), dto.getAmount());
            walletService.freezeTransferAmount(sourceWallet.getId(), dto.getAmount());
            rabbitTemplate.convertAndSend(WALLET_BALANCE_UPDATE_EXCHANGE, "", new WalletBalanceUpdateDto(sourceWallet.getId(), dto.getAmount()));

//        MovementEntity movement = MovementEntity.builder()
//                .build();
        } catch (BusinessException ex) {
            log.error("error: {}", ex.getMessage());
            MovementEntity movement = MovementEntity.builder()
                    .entityId(dto.getEntityId())
                    .accountId(dto.getSourceAccountId())
                    .sourceWalletId(dto.getSourceWalletId())
                    .targetWalletId(dto.getTargetWalletId())
                    .amount(dto.getAmount())
                    .state(MovementState.DECLINED)
                    .createdAt(LocalDateTime.now())
                    .modifiedAt(LocalDateTime.now())
                    .build();

            movementService.insert(movement);
            rabbitTemplate.convertAndSend(MOVEMENT_BROADCAST_EXCHANGE, "",
                    new MovementBroadCastDto(movement, ex.getMessage()));

        } catch (Exception ex) {

        }
    }
}
