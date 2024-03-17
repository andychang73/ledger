package com.abstractionizer.ledger.read.handler;

import com.abstractionizer.ledger.read.model.vo.BalanceHistoryVo;
import com.abstractionizer.ledger.read.model.vo.WalletDetailAndHistoryUpdateDto;
import com.abstractionizer.ledger.read.service.BalanceHistoryCryptoService;
import com.abstractionizer.ledger.read.storage.rmdb.entity.BalanceHistoryCryptoEntity;
import com.abstractionizer.module.enumeration.AssetType;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class BalanceHistoryCryptoHandler implements BalanceHistoryHandler {

    private final BalanceHistoryCryptoService balanceHistoryCryptoService;

    public BalanceHistoryCryptoHandler(BalanceHistoryCryptoService balanceHistoryCryptoService) {
        this.balanceHistoryCryptoService = balanceHistoryCryptoService;
    }

    @Override
    public List<BalanceHistoryVo> getBalanceHistoryByDates(@NonNull final Long entityId, @NonNull final Long accountId, @NonNull final Long walletId,
                                                           @NonNull final LocalDateTime from, @NonNull final LocalDateTime to) {
        return balanceHistoryCryptoService.getBalanceHistory(entityId, accountId, walletId, from, to);
    }


    @Override
    public void insertBalanceHistory(@NonNull final WalletDetailAndHistoryUpdateDto dto) {

        BalanceHistoryCryptoEntity sourceHistory = BalanceHistoryCryptoEntity.builder()
                .entityId(dto.getEntityId())
                .accountId(dto.getSourceAccountId())
                .walletId(dto.getSourceWalletId())
                .assetCode(dto.getAssetCode())
                .assetName(dto.getAssetName())
                .sourceWalletId(dto.getSourceWalletId())
                .targetWalletId(dto.getTargetWalletId())
                .amount(dto.getAmount().negate())
                .balance(dto.getSourceBalance())
                .build();

        BalanceHistoryCryptoEntity targetHistory = BalanceHistoryCryptoEntity.builder()
                .entityId(dto.getEntityId())
                .accountId(dto.getTargetAccountId())
                .walletId(dto.getTargetWalletId())
                .assetCode(dto.getAssetCode())
                .assetName(dto.getAssetName())
                .sourceWalletId(dto.getSourceWalletId())
                .targetWalletId(dto.getTargetWalletId())
                .amount(dto.getAmount())
                .balance(dto.getTargetBalance())
                .build();

        balanceHistoryCryptoService.insertBatch(List.of(sourceHistory, targetHistory));
    }

    @Override
    public AssetType getAssetType() {
        return AssetType.CRYPTO;
    }
}
