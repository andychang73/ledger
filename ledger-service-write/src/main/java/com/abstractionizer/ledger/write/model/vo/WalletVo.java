package com.abstractionizer.ledger.write.model.vo;

import com.abstractionizer.module.enumeration.AssetType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletVo {
    private Long id;
    private AssetType assetType;
    private String assetCode;
    private String assetName;
    private BigDecimal balance;
    private BigDecimal freezeBalance;
}
