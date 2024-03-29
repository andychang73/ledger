package com.abstractionizer.ledger.read.storage.rmdb.mapper;

import com.abstractionizer.ledger.read.model.vo.BalanceHistoryVo;
import com.abstractionizer.ledger.read.storage.rmdb.entity.BalanceHistoryCryptoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
@Repository
public interface BalanceHistoryCryptoMapper extends BaseMapper<BalanceHistoryCryptoEntity> {

    List<BalanceHistoryVo> selectByEntityIdAndAccountIdAndWalletIdAndFromDateAndToDate(Long entityId, Long accountId, Long walletId, LocalDateTime from, LocalDateTime to);

    void insertBatch(List<BalanceHistoryCryptoEntity> entities);
}
