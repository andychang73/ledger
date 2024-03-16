package com.abstractionizer.ledger.gateway.model.vo;

import com.abstractionizer.module.enumeration.AccountState;
import lombok.Data;

import java.util.List;

@Data
public class AccountDetailVo {
    private Long accountId;
    private AccountState state;
    private List<WalletDetailVo> walletDetails;
}
