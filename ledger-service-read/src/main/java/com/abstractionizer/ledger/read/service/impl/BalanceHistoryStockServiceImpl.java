package com.abstractionizer.ledger.read.service.impl;

import com.abstractionizer.ledger.read.model.vo.BalanceHistoryVo;
import com.abstractionizer.ledger.read.service.BalanceHistoryStockService;
import com.abstractionizer.ledger.read.storage.rmdb.entity.BalanceHistoryStockEntity;
import com.abstractionizer.ledger.read.storage.rmdb.mapper.BalanceHistoryStockMapper;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BalanceHistoryStockServiceImpl implements BalanceHistoryStockService {

    private final BalanceHistoryStockMapper balanceHistoryStockMapper;

    public BalanceHistoryStockServiceImpl(BalanceHistoryStockMapper balanceHistoryStockMapper) {
        this.balanceHistoryStockMapper = balanceHistoryStockMapper;
    }

    @Override
    public List<BalanceHistoryVo> getBalanceHistory(@NonNull final Long entityId, @NonNull final Long accountId, @NonNull final Long walletId,
                                                    @NonNull final LocalDateTime from, @NonNull final LocalDateTime to) {
        return balanceHistoryStockMapper.selectByEntityIdAndAccountIdAndWalletIdAndFromDateAndToDate(entityId, accountId, walletId, from, to);
    }

    @Override
    public void insertBatch(@NonNull final List<BalanceHistoryStockEntity> entities) {
        if(entities.isEmpty()){
            return;
        }
        balanceHistoryStockMapper.insertBatch(entities);
    }
}
