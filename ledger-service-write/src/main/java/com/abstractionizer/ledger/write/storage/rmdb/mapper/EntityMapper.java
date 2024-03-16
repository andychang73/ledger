package com.abstractionizer.ledger.write.storage.rmdb.mapper;

import com.abstractionizer.ledger.write.model.vo.AccountVo;
import com.abstractionizer.ledger.write.storage.rmdb.entity.EntityEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface EntityMapper extends BaseMapper<EntityEntity> {

    AccountVo selectByEntityIdAndAccountId(Long entityId, Long accountId);

}
