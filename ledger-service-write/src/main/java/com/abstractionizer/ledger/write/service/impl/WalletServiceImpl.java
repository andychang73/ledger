package com.abstractionizer.ledger.write.service.impl;

import com.abstractionizer.ledger.write.model.vo.SimpleWalletVo;
import com.abstractionizer.ledger.write.model.vo.WalletVo;
import com.abstractionizer.ledger.write.service.WalletService;
import com.abstractionizer.ledger.write.storage.rmdb.entity.WalletEntity;
import com.abstractionizer.ledger.write.storage.rmdb.mapper.WalletMapper;
import com.abstractionizer.module.exception.BusinessException;
import com.abstractionizer.module.exception.DeclineException;
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
            throw new DeclineException(INSUFFICIENT_FUND);
        }
    }

    @Override
    public void checkIfBothAssetTypeAreSameOrThrow(final WalletVo sourceWallet, final WalletVo targetWallet) {
        if(sourceWallet.getAssetType() != targetWallet.getAssetType() || !sourceWallet.getAssetCode().equals(targetWallet.getAssetCode())){
            throw new DeclineException(ASSET_TYPE_NOT_SAME);
        }
    }

    @Override
    public void reduceAmountFromSourceWallet(@NonNull final Long sourceWalletId, @NonNull final BigDecimal amount) {
        if(walletMapper.reduceBalanceById(sourceWalletId, amount) != 1){
            throw new BusinessException(UPDATE_DATA_FAILED);
        }
    }

    @Override
    public void addBalanceToTargetWallet(@NonNull final Long targetWalletId, @NonNull final BigDecimal amount) {
        if(walletMapper.addBalanceById(targetWalletId, amount) != 1){
            throw new BusinessException(UPDATE_DATA_FAILED);
        };
    }

    @Override
    public WalletEntity getWalletOrThrow(@NonNull final Long id) {
        return Optional.ofNullable(walletMapper.selectById(id)).orElseThrow(() -> new BusinessException(DATA_NOT_FOUND));
    }

    @Override
    public SimpleWalletVo getWalletVoOrThrow(Long id) {
        WalletEntity wallet = getWalletOrThrow(id);
        return SimpleWalletVo.builder()
                .id(wallet.getId())
                .accountId(wallet.getAccountId())
                .assetId(wallet.getAssetId())
                .balance(wallet.getBalance())
                .modifiedAt(wallet.getModifiedAt())
                .build();
    }

}
