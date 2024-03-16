package com.abstractionizer.ledger.read.service.impl;

import com.abstractionizer.ledger.read.model.vo.BalanceHistoryVo;
import com.abstractionizer.ledger.read.model.vo.BalanceHistoryVoBondVo;
import com.abstractionizer.ledger.read.service.BalanceHistoryBondService;
import com.abstractionizer.ledger.read.storage.rmdb.mapper.BalanceHistoryBondMapper;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BalanceHistoryBondServiceImpl implements BalanceHistoryBondService {

    private final BalanceHistoryBondMapper balanceHistoryBondMapper;

    public BalanceHistoryBondServiceImpl(BalanceHistoryBondMapper balanceHistoryBondMapper) {
        this.balanceHistoryBondMapper = balanceHistoryBondMapper;
    }

    @Override
    public List<BalanceHistoryVo> getBalanceHistory(@NonNull final Long entityId, @NonNull final Long accountId, @NonNull final Long walletId,
                                                    @NonNull final LocalDateTime from, @NonNull final LocalDateTime to) {
        return balanceHistoryBondMapper.selectByEntityIdAndAccountIdAndWalletIdAndFromDateAndToDate(entityId, accountId, walletId, from, to);
    }
}
