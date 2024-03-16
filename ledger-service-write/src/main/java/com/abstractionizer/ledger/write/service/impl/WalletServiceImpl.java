package com.abstractionizer.ledger.write.service.impl;

import com.abstractionizer.ledger.write.service.WalletService;
import com.abstractionizer.ledger.write.storage.rmdb.entity.WalletEntity;
import com.abstractionizer.ledger.write.storage.rmdb.mapper.WalletMapper;
import com.abstractionizer.module.enumeration.AssetType;
import com.abstractionizer.module.exception.BusinessException;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

import static com.abstractionizer.module.error.Error.*;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletMapper walletMapper;

    public WalletServiceImpl(WalletMapper walletMapper) {
        this.walletMapper = walletMapper;
    }

    @Override
    public void checkIfSufficientFundOrThrow(@NonNull final BigDecimal balance, @NotNull final BigDecimal freezeBalance,
                                             @NonNull final BigDecimal amount) {
        if(balance.subtract(freezeBalance).compareTo(amount) < 0){
            throw new BusinessException(INSUFFICIENT_FUND);
        }
    }

    @Override
    public void checkIfBothAssetTypeAreSameOrThrow(@NonNull final AssetType sourceAssetType, @NonNull final AssetType targetAssetType) {
        if(sourceAssetType != targetAssetType){
            throw new BusinessException(ASSET_TYPE_NOT_SAME);
        }
    }

    @Override
    public void freezeTransferAmount(@NonNull final Long id, @NonNull final BigDecimal amount) {
        if(walletMapper.addFreezeAmountById(id, amount) != 1){
            throw new BusinessException(UPDATE_DATA_FAILED);
        }
    }

    @Override
    public WalletEntity getWallet(@NonNull final Long id) {
        return Optional.ofNullable(walletMapper.selectById(id)).orElseThrow(() -> new BusinessException(DATA_NOT_FOUND));
    }
}
