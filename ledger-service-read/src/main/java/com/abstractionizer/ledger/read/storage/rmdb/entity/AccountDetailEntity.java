package com.abstractionizer.ledger.read.storage.rmdb.entity;

import com.abstractionizer.module.enumeration.AccountState;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("account_detail")
public class AccountDetailEntity {

    @TableId(type = IdType.INPUT)
    private Long id;

    private Long entityId;

    private AccountState state;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
