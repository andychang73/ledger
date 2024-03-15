package com.abstractionizer.ledger.write.model.dto;

import com.abstractionizer.module.enumeration.AccountState;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ModifyAccountStateDto {

    @Min(value = 1)
    @NotNull
    private Long accountId;

    @NotNull
    private AccountState accountState;
}
