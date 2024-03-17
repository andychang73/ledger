package com.abstractionizer.ledger.read.model.vo;

import com.abstractionizer.module.enumeration.AssetType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class WalletDetailAndHistoryUpdateDto {

    @Min(value = 1)
    @NotNull
    private Long entityId;

    @Min(value = 1)
    @NotNull
    private Long sourceAccountId;

    @Min(value = 1)
    @NotNull
    private Long targetAccountId;

    @NotNull
    private AssetType assetType;

    @NotBlank
    private String assetCode;

    @NotBlank
    private String assetName;

    @Min(value = 1)
    @NotNull
    private Long sourceWalletId;

    @Min(value = 1)
    @NotNull
    private BigDecimal sourceBalance;

    @Min(value = 1)
    @NotNull
    private Long targetWalletId;

    @Min(value = 1)
    @NotNull
    private BigDecimal targetBalance;

    @Min(value = 1)
    @NotNull
    private BigDecimal amount;

}
