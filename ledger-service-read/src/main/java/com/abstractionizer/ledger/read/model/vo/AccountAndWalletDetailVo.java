package com.abstractionizer.ledger.read.model.vo;

import com.abstractionizer.module.enumeration.AccountState;
import com.abstractionizer.module.enumeration.AssetType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountAndWalletDetailVo {
    private Long accountId;
    private AccountState state;
    private Long walletId;
    private AssetType assetType;
    private String assetCode;
    private String assetName;
    private BigDecimal balance;
}
