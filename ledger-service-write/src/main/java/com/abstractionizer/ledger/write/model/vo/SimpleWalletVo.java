package com.abstractionizer.ledger.write.model.vo;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class SimpleWalletVo {
    private Long id;
    private Long accountId;
    private Long assetId;
    private BigDecimal balance;
    private LocalDateTime modifiedAt;
}
