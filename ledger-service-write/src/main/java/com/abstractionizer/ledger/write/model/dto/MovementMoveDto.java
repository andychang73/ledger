package com.abstractionizer.ledger.write.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MovementMoveDto {
    private Long entityId;
    private Long sourceAccountId;
    private Long sourceWalletId;
    private Long targetAccountId;
    private Long targetWalletId;
    private BigDecimal amount;
}
