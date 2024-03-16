package com.abstractionizer.ledger.read.model.vo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDetailAndHistoryUpdateDto {

    @Min(value = 1)
    @NotNull
    private Long walletId;

    @NotBlank
    private String assetCode;

    @NotBlank
    private String assetName;

    @Min(value = 1)
    @NotNull
    private Long sourceWalletId;

    @Min(value = 1)
    @NotNull
    private Long targetWalletId;

    @Min(value = 1)
    @NotNull
    private BigDecimal latestBalance;

    @NotNull
    private BigDecimal amount;
}
