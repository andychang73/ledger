package com.abstractionizer.ledger.read.service.impl;

import com.abstractionizer.ledger.read.service.BalanceHistoryStockService;
import com.abstractionizer.ledger.read.storage.rmdb.mapper.BalanceHistoryStockMapper;
import org.springframework.stereotype.Service;

@Service
public class BalanceHistoryStockServiceImpl implements BalanceHistoryStockService {

    private final BalanceHistoryStockMapper balanceHistoryStockMapper;

    public BalanceHistoryStockServiceImpl(BalanceHistoryStockMapper balanceHistoryStockMapper) {
        this.balanceHistoryStockMapper = balanceHistoryStockMapper;
    }
}
