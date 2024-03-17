package com.abstractionizer.ledger.read.storage.rmdb.mapper;

import com.abstractionizer.ledger.read.storage.rmdb.entity.MovementEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MovementMapper extends BaseMapper<MovementEntity> {
    void upsert(MovementEntity entity);

    List<MovementEntity> selectByEntityId(Long entityId);
}
