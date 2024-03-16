package com.abstractionizer.ledger.read.model.vo;

import com.abstractionizer.module.enumeration.AccountState;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AccountDetailVo {
    private Long accountId;
    private AccountState state;
    private List<WalletDetailVo> walletDetails;
}
