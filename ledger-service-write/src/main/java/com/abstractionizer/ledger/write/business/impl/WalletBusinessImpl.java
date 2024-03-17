package com.abstractionizer.ledger.write.business.impl;

import com.abstractionizer.ledger.write.business.WalletBusiness;
import com.abstractionizer.ledger.write.model.dto.MovementMoveDto;
import com.abstractionizer.ledger.write.model.dto.WalletDetailUpdateDto;
import com.abstractionizer.ledger.write.model.vo.AccountVo;
import com.abstractionizer.ledger.write.model.vo.WalletVo;
import com.abstractionizer.ledger.write.service.AccountService;
import com.abstractionizer.ledger.write.service.EntityService;
import com.abstractionizer.ledger.write.service.WalletService;
import com.abstractionizer.ledger.write.storage.rmdb.entity.MovementEntity;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class WalletBusinessImpl implements WalletBusiness {

    public WalletBusinessImpl(EntityService entityService, AccountService accountService,
                              WalletService walletService) {
        this.entityService = entityService;
        this.accountService = accountService;
        this.walletService = walletService;
    }

    private final EntityService entityService;
    private final AccountService accountService;
    private final WalletService walletService;

    @Override
    public WalletDetailUpdateDto validateMovement(@NonNull final MovementMoveDto dto) {
        return validateMovement(dto.getEntityId(), dto.getSourceAccountId(), dto.getTargetAccountId(),
                dto.getSourceWalletId(), dto.getTargetWalletId(), dto.getAmount());
    }

    @Override
    public WalletDetailUpdateDto validateMovement(@NonNull final MovementEntity movement) {
        return validateMovement(movement.getEntityId(), movement.getSourceAccountId(), movement.getTargetAccountId(),
                movement.getSourceWalletId(), movement.getTargetWalletId(), movement.getAmount());
    }

    @Override
    public WalletDetailUpdateDto validateMovement(@NonNull final Long entityId, @NonNull final Long sourceAccountId, @NonNull final Long targetAccountId,
                                                  @NonNull final Long sourceWalletId, @NonNull final Long targetWalletId, @NonNull final BigDecimal amount) {
        AccountVo sourceAccount = entityService.getAccountOrThrow(entityId, sourceAccountId);
        accountService.validateAccountStateIsOpen(sourceAccount.getAccountState());

        AccountVo targetAccount = entityService.getAccountOrThrow(entityId, targetAccountId);
        accountService.validateAccountStateIsOpen(targetAccount.getAccountState());

        WalletVo sourceWallet = accountService.selectWalletForUpdateOrThrow(sourceAccount.getId(), sourceWalletId);
        WalletVo targetWallet = accountService.selectWalletForUpdateOrThrow(targetAccount.getId(), targetWalletId);

        walletService.checkIfBothAssetTypeAreSameOrThrow(sourceWallet, targetWallet);
        walletService.checkIfSufficientFundOrThrow(sourceWallet.getBalance(), amount);

        return WalletDetailUpdateDto.builder()
                .entityId(entityId)
                .sourceAccountId(sourceAccount.getId())
                .targetAccountId(targetAccount.getId())
                .assetType(sourceWallet.getAssetType())
                .assetCode(sourceWallet.getAssetCode())
                .assetName(sourceWallet.getAssetName())
                .sourceWalletId(sourceWallet.getId())
                .targetWalletId(targetWallet.getId())
                .amount(amount)
                .build();
    }

    @Override
    public WalletDetailUpdateDto checkFundAndGetDetail(@NonNull final BigDecimal newAmount, @NonNull final MovementEntity movement) {

        if(newAmount.compareTo(BigDecimal.ZERO) > 0){
            return validateMovement(movement.getEntityId(), movement.getSourceAccountId(), movement.getTargetAccountId(),
                    movement.getSourceWalletId(), movement.getTargetWalletId(), newAmount);
        }

        return validateMovement(movement.getEntityId(), movement.getTargetAccountId(), movement.getSourceAccountId(),
                movement.getTargetWalletId(), movement.getSourceWalletId(), newAmount.negate());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void transferToTargetWallet(@NonNull final Long sourceWalletId, @NonNull final Long targetWalletId, @NonNull final BigDecimal amount) {
        walletService.reduceAmountFromSourceWallet(sourceWalletId, amount);
        walletService.addBalanceToTargetWallet(targetWalletId, amount);
    }
}
