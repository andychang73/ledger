package com.abstractionizer.ledger.read.service;

import com.abstractionizer.ledger.read.model.dto.WalletVo;

public interface WalletDetailService {
    void updateBalance(WalletVo dto);
}
