package com.abstractionizer.ledger.read.storage.rmdb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("balance_history_fiat")
public class BalanceHistoryFiatEntity{

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long entityId;

    private Long accountId;

    private Long walletId;

    private String assetCode;

    private String assetName;

    private Long sourceWalletId;

    private Long targetWalletId;

    private BigDecimal amount;

    private BigDecimal balance;

    private LocalDateTime createdAt;
}
