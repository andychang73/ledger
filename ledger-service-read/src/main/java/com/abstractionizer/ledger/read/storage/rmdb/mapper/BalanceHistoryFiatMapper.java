package com.abstractionizer.ledger.read.storage.rmdb.mapper;

import com.abstractionizer.ledger.read.storage.rmdb.entity.BalanceHistoryFiatEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BalanceHistoryFiatMapper extends BaseMapper<BalanceHistoryFiatEntity> {
}
