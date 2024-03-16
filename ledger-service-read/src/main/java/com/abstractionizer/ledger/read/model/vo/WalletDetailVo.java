package com.abstractionizer.ledger.read.model.vo;

import com.abstractionizer.module.enumeration.AssetType;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class WalletDetailVo {
    private Long walletId;
    private AssetType assetType;
    private String assetCode;
    private String assetName;
    private BigDecimal balance;
}
