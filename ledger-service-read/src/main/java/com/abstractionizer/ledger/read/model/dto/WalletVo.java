package com.abstractionizer.ledger.read.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class WalletVo {
    private Long id;
    private Long accountId;
    private Long assetId;
    private BigDecimal balance;
    private LocalDateTime modifiedAt;
}
