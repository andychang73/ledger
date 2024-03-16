package com.abstractionizer.ledger.read.model.dto;

import com.abstractionizer.module.enumeration.AssetType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BalanceHistoryDto {
    private AssetType assetType;
    private Long entityId;
    private Long accountId;
    private Long walletId;
    private LocalDateTime from;
    private LocalDateTime to;
}
