package com.abstractionizer.ledger.write.business.impl;

import com.abstractionizer.ledger.write.business.WalletBusiness;
import com.abstractionizer.ledger.write.model.dto.MovementMoveDto;
import com.abstractionizer.ledger.write.model.dto.WalletDetailUpdateDto;
import com.abstractionizer.ledger.write.model.vo.AccountVo;
import com.abstractionizer.ledger.write.model.vo.WalletVo;
import com.abstractionizer.ledger.write.service.AccountService;
import com.abstractionizer.ledger.write.service.EntityService;
import com.abstractionizer.ledger.write.service.WalletService;
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
    public WalletDetailUpdateDto validateMovementDto(@NonNull final MovementMoveDto dto) {

        AccountVo sourceAccount = entityService.getAccountOrThrow(dto.getEntityId(), dto.getSourceAccountId());
        accountService.validateAccountStateIsOpen(sourceAccount.getAccountState());

        AccountVo targetAccount = entityService.getAccountOrThrow(dto.getEntityId(), dto.getTargetAccountId());
        accountService.validateAccountStateIsOpen(targetAccount.getAccountState());

        WalletVo sourceWallet = accountService.selectWalletForUpdateOrThrow(sourceAccount.getId(), dto.getSourceWalletId());
        WalletVo targetWallet = accountService.selectWalletForUpdateOrThrow(targetAccount.getId(), dto.getTargetWalletId());

        walletService.checkIfBothAssetTypeAreSameOrThrow(sourceWallet, targetWallet);
        walletService.checkIfSufficientFundOrThrow(sourceWallet.getBalance(), sourceWallet.getFreezeBalance(), dto.getAmount());

        return WalletDetailUpdateDto.builder()
                .entityId(dto.getEntityId())
                .sourceAccountId(sourceAccount.getId())
                .targetAccountId(targetAccount.getId())
                .assetType(sourceWallet.getAssetType())
                .assetCode(sourceWallet.getAssetCode())
                .assetName(sourceWallet.getAssetName())
                .sourceWalletId(sourceWallet.getId())
                .targetWalletId(targetWallet.getId())
                .amount(dto.getAmount())
                .build();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void transferToTargetWallet(@NonNull final Long sourceWalletId, @NonNull final Long targetWalletId, @NonNull final BigDecimal amount) {
        walletService.reduceAmountFromSourceWallet(sourceWalletId, amount);
        walletService.addBalanceToTargetWallet(targetWalletId, amount);
    }
}
