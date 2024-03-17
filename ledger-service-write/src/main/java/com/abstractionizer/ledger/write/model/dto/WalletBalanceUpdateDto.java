package com.abstractionizer.ledger.write.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;


// todo to be deleted

@Data
@AllArgsConstructor
public class WalletBalanceUpdateDto {
    private Long id;
    private BigDecimal amount;
}
