package com.abstractionizer.ledger.write.service.impl;

import com.abstractionizer.ledger.write.service.WalletService;
import com.abstractionizer.ledger.write.storage.rmdb.mapper.WalletMapper;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    private final WalletMapper walletMapper;

    public WalletServiceImpl(WalletMapper walletMapper) {
        this.walletMapper = walletMapper;
    }
}
