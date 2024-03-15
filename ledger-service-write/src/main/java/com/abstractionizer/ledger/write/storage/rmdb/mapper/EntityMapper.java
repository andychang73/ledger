package com.abstractionizer.ledger.write.storage.rmdb.mapper;

import com.abstractionizer.ledger.write.storage.rmdb.entity.EntityEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EntityMapper extends BaseMapper<EntityEntity> {

}
