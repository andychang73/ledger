package com.abstractionizer.ledger.gateway.model.vo;

import com.abstractionizer.module.enumeration.AssetType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletDetailVo {
    private Long walletId;
    private AssetType assetType;
    private String assetCode;
    private String assetName;
    private BigDecimal balance;
}
