package com.abstractionizer.ledger.write.service;

import com.abstractionizer.ledger.write.storage.rmdb.entity.WalletEntity;
import com.abstractionizer.module.enumeration.AssetType;

import java.math.BigDecimal;

public interface WalletService {
    void checkIfSufficientFundOrThrow(BigDecimal balance, BigDecimal freezeBalance, BigDecimal amount);

    void checkIfBothAssetTypeAreSameOrThrow(AssetType sourceAssetType, AssetType targetAssetType);

    void freezeTransferAmount(Long id, BigDecimal amount);

    WalletEntity getWallet(Long id);
}
