package com.abstractionizer.ledger.write.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MovementModifyDto {
    @Min(value = 1)
    @NotNull
    private Long id;

    @Min(value = 1)
    @NotNull
    private BigDecimal newAmount;
}
