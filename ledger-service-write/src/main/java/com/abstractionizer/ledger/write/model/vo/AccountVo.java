package com.abstractionizer.ledger.write.model.vo;

import com.abstractionizer.module.enumeration.AccountState;
import lombok.Data;

@Data
public class AccountVo {
    private Long id;
    private Long entityId;
    private AccountState accountState;
}
