package com.abstractionizer.ledger.read.service;

import com.abstractionizer.ledger.read.model.dto.WalletVo;

import java.math.BigDecimal;

public interface WalletDetailService {
    void updateBalance(WalletVo dto);

    void updateBalance(Long id, BigDecimal balance);
}
