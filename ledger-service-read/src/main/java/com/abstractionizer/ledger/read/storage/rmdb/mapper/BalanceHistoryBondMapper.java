package com.abstractionizer.ledger.read.storage.rmdb.mapper;

import com.abstractionizer.ledger.read.storage.rmdb.entity.BalanceHistoryBondEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BalanceHistoryBondMapper extends BaseMapper<BalanceHistoryBondEntity> {
}
