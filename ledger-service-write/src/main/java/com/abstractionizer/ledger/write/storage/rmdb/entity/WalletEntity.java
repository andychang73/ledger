package com.abstractionizer.ledger.write.storage.rmdb.entity;

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
@TableName("wallet")
public class WalletEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long accountId;

    private Long assetId;

    private BigDecimal balance;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
