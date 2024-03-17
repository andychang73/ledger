package com.abstraction.ledger.client.model.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SimpleWalletVo {
    private Long id;
    private Long accountId;
    private Long assetId;
    private BigDecimal balance;
    private LocalDateTime modifiedAt;
}
