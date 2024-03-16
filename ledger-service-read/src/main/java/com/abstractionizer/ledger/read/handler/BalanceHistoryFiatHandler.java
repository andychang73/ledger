package com.abstractionizer.ledger.read.handler;

import com.abstractionizer.ledger.read.model.vo.BalanceHistoryVo;
import com.abstractionizer.ledger.read.service.BalanceHistoryFiatService;
import com.abstractionizer.module.enumeration.AssetType;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class BalanceHistoryFiatHandler implements BalanceHistoryHandler{

    private final BalanceHistoryFiatService balanceHistoryFiatService;

    public BalanceHistoryFiatHandler(BalanceHistoryFiatService balanceHistoryFiatService) {
        this.balanceHistoryFiatService = balanceHistoryFiatService;
    }

    @Override
    public List<BalanceHistoryVo> getBalanceHistoryByDates(@NonNull final Long entityId, @NonNull final Long accountId, @NonNull final Long walletId,
                                                           @NonNull final LocalDateTime from, @NonNull final LocalDateTime to) {
        return balanceHistoryFiatService.getBalanceHistory(entityId, accountId, walletId, from, to);
    }

    @Override
    public AssetType getAssetType() {
        return AssetType.FIAT;
    }
}
