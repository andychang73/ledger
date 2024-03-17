package com.abstractionizer.ledger.read.model.vo;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class WalletVo {
    private Long id;
    private Long accountId;
    private Long assetId;
    private BigDecimal balance;
    private LocalDateTime modifiedAt;
}
