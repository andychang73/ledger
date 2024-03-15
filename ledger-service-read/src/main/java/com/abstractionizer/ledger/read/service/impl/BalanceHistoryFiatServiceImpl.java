package com.abstractionizer.ledger.read.service.impl;

import com.abstractionizer.ledger.read.service.BalanceHistoryFiatService;
import com.abstractionizer.ledger.read.storage.rmdb.mapper.BalanceHistoryFiatMapper;
import org.springframework.stereotype.Service;

@Service
public class BalanceHistoryFiatServiceImpl implements BalanceHistoryFiatService {

    private final BalanceHistoryFiatMapper balanceHistoryFiatMapper;

    public BalanceHistoryFiatServiceImpl(BalanceHistoryFiatMapper balanceHistoryFiatMapper) {
        this.balanceHistoryFiatMapper = balanceHistoryFiatMapper;
    }
}
