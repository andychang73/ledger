package com.abstractionizer.ledger.write.storage.rmdb.entity;

import com.abstractionizer.module.enumeration.AssetStatus;
import com.abstractionizer.module.enumeration.AssetType;
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
@TableName("asset")
public class AssetEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private AssetType type;

    private String code;

    private String name;

    private AssetStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
}
