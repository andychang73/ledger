package com.abstractionizer.ledger.read.handler;

import com.abstractionizer.ledger.read.model.vo.BalanceHistoryVo;
import com.abstractionizer.module.enumeration.AssetType;

import java.time.LocalDateTime;
import java.util.List;

public interface BalanceHistoryHandler{

    List<BalanceHistoryVo> getBalanceHistoryByDates(Long entityId, Long accountId, Long walletId, LocalDateTime from, LocalDateTime to);

    AssetType getAssetType();
}
