package com.abstractionizer.ledger.read.model.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BalanceHistoryVo {
    protected LocalDateTime createdAt;
    protected String assetCode;
    protected String assetName;
    protected Long sourceWalletId;
    protected Long targetWalletId;
    protected BigDecimal amount;
    protected BigDecimal balance;
}
