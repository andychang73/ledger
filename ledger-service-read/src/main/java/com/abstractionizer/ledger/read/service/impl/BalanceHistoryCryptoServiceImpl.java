package com.abstractionizer.ledger.read.service.impl;

import com.abstractionizer.ledger.read.model.vo.BalanceHistoryVo;
import com.abstractionizer.ledger.read.model.vo.BalanceHistoryVoCryptoVo;
import com.abstractionizer.ledger.read.service.BalanceHistoryCryptoService;
import com.abstractionizer.ledger.read.storage.rmdb.entity.BalanceHistoryCryptoEntity;
import com.abstractionizer.ledger.read.storage.rmdb.mapper.BalanceHistoryCryptoMapper;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BalanceHistoryCryptoServiceImpl implements BalanceHistoryCryptoService {

    private final BalanceHistoryCryptoMapper balanceHistoryCryptoMapper;

    public BalanceHistoryCryptoServiceImpl(BalanceHistoryCryptoMapper balanceHistoryCryptoMapper) {
        this.balanceHistoryCryptoMapper = balanceHistoryCryptoMapper;
    }

    @Override
    public List<BalanceHistoryVo> getBalanceHistory(@NonNull final Long entityId, @NonNull final Long accountId, @NonNull final Long walletId,
                                                    @NonNull final LocalDateTime from, @NonNull final LocalDateTime to) {
        return balanceHistoryCryptoMapper.selectByEntityIdAndAccountIdAndWalletIdAndFromDateAndToDate(entityId, accountId, walletId, from, to);
    }

    @Override
    public void insertBatch(@NonNull final List<BalanceHistoryCryptoEntity> entities) {
        if(entities.isEmpty()){
            return;
        }
        balanceHistoryCryptoMapper.insertBatch(entities);
    }
}
