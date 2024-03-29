package com.abstractionizer.ledger.read.storage.rmdb.entity;

import com.abstractionizer.module.enumeration.MovementState;
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
@TableName("movement")
public class MovementEntity {

    @TableId(type = IdType.INPUT)
    private Long id;

    private Long entityId;

    private Long sourceAccountId;

    private Long targetAccountId;

    private Long sourceWalletId;

    private Long targetWalletId;

    private BigDecimal amount;

    private MovementState state;

    private String remark;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
