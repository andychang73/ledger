package com.abstractionizer.ledger.write.storage.rmdb.mapper;

import com.abstractionizer.ledger.write.model.vo.WalletVo;
import com.abstractionizer.ledger.write.storage.rmdb.entity.AccountEntity;
import com.abstractionizer.module.enumeration.AccountState;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountMapper extends BaseMapper<AccountEntity> {

    AccountEntity findById(Long accountId);

    int updateAccountStatus(Long id, AccountState state);

    WalletVo selectByIdAndWalletIdForUpdate(Long accountId, Long walletId);
}
