package com.abstractionizer.ledger.read.service.impl;

import com.abstractionizer.ledger.read.service.WalletDetailService;
import com.abstractionizer.ledger.read.storage.rmdb.mapper.WalletDetailMapper;
import org.springframework.stereotype.Service;

@Service
public class WalletDetailServiceImpl implements WalletDetailService {

    private final WalletDetailMapper walletDetailMapper;

    public WalletDetailServiceImpl(WalletDetailMapper walletDetailMapper) {
        this.walletDetailMapper = walletDetailMapper;
    }
}
