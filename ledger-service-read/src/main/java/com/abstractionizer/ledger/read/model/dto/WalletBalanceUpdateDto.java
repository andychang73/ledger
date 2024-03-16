package com.abstractionizer.ledger.read.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletBalanceUpdateDto {
    private Long id;
    private BigDecimal amount;
}