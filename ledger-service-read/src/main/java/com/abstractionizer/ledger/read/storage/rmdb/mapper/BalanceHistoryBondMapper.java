package com.abstractionizer.ledger.read.storage.rmdb.mapper;

import com.abstractionizer.ledger.read.model.vo.BalanceHistoryVo;
import com.abstractionizer.ledger.read.model.vo.BalanceHistoryVoBondVo;
import com.abstractionizer.ledger.read.storage.rmdb.entity.BalanceHistoryBondEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
@Repository
public interface BalanceHistoryBondMapper extends BaseMapper<BalanceHistoryBondEntity> {

    List<BalanceHistoryVo> selectByEntityIdAndAccountIdAndWalletIdAndFromDateAndToDate(Long entityId, Long accountId, Long walletId, LocalDateTime from, LocalDateTime to);

    void insertBatch(List<BalanceHistoryBondEntity> entities);
}
