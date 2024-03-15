package com.abstractionizer.ledger.read.storage.rmdb.mapper;

import com.abstractionizer.ledger.read.model.vo.AccountAndWalletDetailVo;
import com.abstractionizer.ledger.read.storage.rmdb.entity.AccountDetailEntity;
import com.abstractionizer.module.enumeration.AccountState;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountDetailMapper extends BaseMapper<AccountDetailEntity> {

    int modifyState(Long id, AccountState state);

    List<AccountAndWalletDetailVo> selectAccountAndWalletDetailsByEntityId(Long entityId);
}
