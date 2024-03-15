package com.abstractionizer.ledger.read.storage.rmdb.entity;

import com.abstractionizer.module.enumeration.AssetType;
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
@TableName("wallet_detail")
public class WalletDetailEntity {

    @TableId(type = IdType.INPUT)
    private Long id;

    private Long entityId;

    private Long accountId;

    private AssetType assetType;

    private String assetCode;

    private String assetName;

    private BigDecimal balance;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
