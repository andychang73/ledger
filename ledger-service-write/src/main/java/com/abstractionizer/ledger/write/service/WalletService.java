package com.abstractionizer.ledger.write.service;

import com.abstractionizer.ledger.write.model.vo.SimpleWalletVo;
import com.abstractionizer.ledger.write.model.vo.WalletVo;
import com.abstractionizer.ledger.write.storage.rmdb.entity.WalletEntity;

import java.math.BigDecimal;

public interface WalletService {
    void checkIfSufficientFundOrThrow(BigDecimal balance, BigDecimal freezeBalance, BigDecimal amount);

    void checkIfBothAssetTypeAreSameOrThrow(WalletVo sourceWallet, WalletVo targetWallet);

    void reduceAmountFromSourceWallet(Long sourceWalletId, BigDecimal amount);

    void addBalanceToTargetWallet(Long targetWalletId, BigDecimal amount);

    WalletEntity getWalletOrThrow(Long id);

    SimpleWalletVo getWalletVoOrThrow(Long id);
}
