package com.abstractionizer.ledger.read.service.impl;

import com.abstractionizer.ledger.read.service.BalanceHistoryBondService;
import com.abstractionizer.ledger.read.storage.rmdb.mapper.BalanceHistoryBondMapper;
import org.springframework.stereotype.Service;

@Service
public class BalanceHistoryBondServiceImpl implements BalanceHistoryBondService {

    private final BalanceHistoryBondMapper balanceHistoryBondMapper;

    public BalanceHistoryBondServiceImpl(BalanceHistoryBondMapper balanceHistoryBondMapper) {
        this.balanceHistoryBondMapper = balanceHistoryBondMapper;
    }
}
