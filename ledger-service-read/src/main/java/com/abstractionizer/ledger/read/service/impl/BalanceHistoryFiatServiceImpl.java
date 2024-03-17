package com.abstractionizer.ledger.read.service.impl;

import com.abstractionizer.ledger.read.model.vo.BalanceHistoryVo;
import com.abstractionizer.ledger.read.model.vo.BalanceHistoryVoFiatVo;
import com.abstractionizer.ledger.read.service.BalanceHistoryFiatService;
import com.abstractionizer.ledger.read.storage.rmdb.entity.BalanceHistoryFiatEntity;
import com.abstractionizer.ledger.read.storage.rmdb.mapper.BalanceHistoryFiatMapper;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BalanceHistoryFiatServiceImpl implements BalanceHistoryFiatService {

    private final BalanceHistoryFiatMapper balanceHistoryFiatMapper;

    public BalanceHistoryFiatServiceImpl(BalanceHistoryFiatMapper balanceHistoryFiatMapper) {
        this.balanceHistoryFiatMapper = balanceHistoryFiatMapper;
    }

    @Override
    public List<BalanceHistoryVo> getBalanceHistory(@NonNull final Long entityId, @NonNull final Long accountId, @NonNull final Long walletId,
                                                    @NonNull final LocalDateTime from, @NonNull final LocalDateTime to) {
        return balanceHistoryFiatMapper.selectByEntityIdAndAccountIdAndWalletIdAndFromDateAndToDate(entityId, accountId, walletId, from, to);
    }

    @Override
    public void insertBatch(@NonNull final List<BalanceHistoryFiatEntity> entities) {
        if(entities.isEmpty()){
            return;
        }
        balanceHistoryFiatMapper.insertBatch(entities);
    }
}
