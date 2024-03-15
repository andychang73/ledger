package com.abstractionizer.ledger.read.service.impl;

import com.abstractionizer.ledger.read.service.BalanceHistoryCryptoService;
import com.abstractionizer.ledger.read.storage.rmdb.mapper.BalanceHistoryCryptoMapper;
import org.springframework.stereotype.Service;

@Service
public class BalanceHistoryCryptoServiceImpl implements BalanceHistoryCryptoService {

    private final BalanceHistoryCryptoMapper balanceHistoryCryptoMapper;

    public BalanceHistoryCryptoServiceImpl(BalanceHistoryCryptoMapper balanceHistoryCryptoMapper) {
        this.balanceHistoryCryptoMapper = balanceHistoryCryptoMapper;
    }
}
