package com.abstractionizer.ledger.read.model.dto;

import com.abstractionizer.module.enumeration.AccountState;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ModifyAccountDetailStateDto {

    @Min(value = 1)
    @NotNull
    private Long accountId;

    @NotNull
    private AccountState accountState;
}
