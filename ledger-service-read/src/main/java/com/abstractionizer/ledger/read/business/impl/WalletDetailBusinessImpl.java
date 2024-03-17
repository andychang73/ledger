package com.abstractionizer.ledger.read.business.impl;

import com.abstractionizer.ledger.read.business.WalletDetailBusiness;
import com.abstractionizer.ledger.read.factory.BalanceHistoryFactory;
import com.abstractionizer.ledger.read.model.vo.WalletDetailAndHistoryUpdateDto;
import com.abstractionizer.ledger.read.service.WalletDetailService;
import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WalletDetailBusinessImpl implements WalletDetailBusiness {

    private final WalletDetailService walletDetailService;
    private final BalanceHistoryFactory balanceHistoryFactory;

    public WalletDetailBusinessImpl(WalletDetailService walletDetailService, BalanceHistoryFactory balanceHistoryFactory) {
        this.walletDetailService = walletDetailService;
        this.balanceHistoryFactory = balanceHistoryFactory;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateWalletBalanceAndInsertBalanceHistory(@NonNull final WalletDetailAndHistoryUpdateDto dto) {

        walletDetailService.updateBalance(dto.getSourceWalletId(), dto.getSourceBalance());
        walletDetailService.updateBalance(dto.getTargetWalletId(), dto.getTargetBalance());
        balanceHistoryFactory.insertBalanceHistory(dto);
    }
}
