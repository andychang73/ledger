package com.abstractionizer.ledger.write.model.dto;

import com.abstractionizer.module.enumeration.AssetType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class WalletDetailUpdateDto {
    private Long entityId;
    private Long sourceAccountId;
    private Long targetAccountId;
    private AssetType assetType;
    private String assetCode;
    private String assetName;
    private Long sourceWalletId;
    private Long targetWalletId;
    private BigDecimal amount;
}
