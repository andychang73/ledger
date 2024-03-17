package com.abstractionizer.ledger.read.service.impl;

import com.abstractionizer.ledger.read.model.dto.WalletVo;
import com.abstractionizer.ledger.read.service.WalletDetailService;
import com.abstractionizer.ledger.read.storage.rmdb.mapper.WalletDetailMapper;
import com.abstractionizer.module.exception.BusinessException;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.abstractionizer.module.error.Error.UPDATE_DATA_FAILED;

@Service
public class WalletDetailServiceImpl implements WalletDetailService {

    private final WalletDetailMapper walletDetailMapper;

    public WalletDetailServiceImpl(WalletDetailMapper walletDetailMapper) {
        this.walletDetailMapper = walletDetailMapper;
    }

    @Override
    public void updateBalance(@NonNull final WalletVo dto) {
        updateBalance(dto.getId(), dto.getBalance());
    }

    @Override
    public void updateBalance(@NonNull final Long id, @NonNull final BigDecimal balance) {
        if(walletDetailMapper.updateBalanceById(id, balance) != 1){
            throw new BusinessException(UPDATE_DATA_FAILED);
        }
    }
}
