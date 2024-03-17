package com.abstractionizer.ledger.read.service;

import com.abstractionizer.ledger.read.model.vo.BalanceHistoryVo;
import com.abstractionizer.ledger.read.storage.rmdb.entity.BalanceHistoryStockEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface BalanceHistoryStockService {

    List<BalanceHistoryVo> getBalanceHistory(Long entityId, Long accountId, Long walletId, LocalDateTime from, LocalDateTime to);

    void insertBatch(List<BalanceHistoryStockEntity> entities);
}
