package com.abstractionizer.ledger.read.service;

import com.abstractionizer.ledger.read.model.vo.BalanceHistoryVo;
import com.abstractionizer.ledger.read.model.vo.BalanceHistoryVoBondVo;
import com.abstractionizer.ledger.read.storage.rmdb.entity.BalanceHistoryBondEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface BalanceHistoryBondService {

    List<BalanceHistoryVo> getBalanceHistory(Long entityId, Long accountId, Long walletId, LocalDateTime from, LocalDateTime to);

    void insertBatch(List<BalanceHistoryBondEntity> entities);
}
