package com.abstractionizer.ledger.read.service;

import com.abstractionizer.ledger.read.model.dto.WalletBalanceUpdateDto;

public interface WalletDetailService {
    void updateBalance(WalletBalanceUpdateDto dto);
}
