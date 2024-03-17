package com.abstraction.ledger.client.entity;

import com.abstractionizer.module.enumeration.MovementState;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class MovementEntity {

    private Long id;

    private Long entityId;

    private Long sourceAccountId;

    private Long targetAccountId;

    private Long sourceWalletId;

    private Long targetWalletId;

    private BigDecimal amount;

    private MovementState state;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
