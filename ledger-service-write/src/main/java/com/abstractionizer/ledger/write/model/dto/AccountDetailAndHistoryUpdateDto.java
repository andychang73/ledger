package com.abstractionizer.ledger.write.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDetailAndHistoryUpdateDto {
    private Long walletId;
    private Long sourceWalletId;
    private Long targetWalletId;
    private Long latestBalance;
    private BigDecimal amount;
}
