package com.abstractionizer.ledger.write.storage.rmdb.mapper;

import com.abstractionizer.ledger.write.storage.rmdb.entity.WalletEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Mapper
@Repository
public interface WalletMapper extends BaseMapper<WalletEntity> {

    int reduceBalanceById(Long id, BigDecimal amount);

    int addBalanceById(Long id, BigDecimal amount);
}
