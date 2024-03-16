package com.abstractionizer.ledger.write.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class WalletBalanceUpdateDto {
    private Long id;
    private BigDecimal amount;
}
