package com.abstractionizer.ledger.read.service.impl;

import com.abstractionizer.ledger.read.model.dto.ModifyAccountDetailStateDto;
import com.abstractionizer.ledger.read.model.vo.AccountAndWalletDetailVo;
import com.abstractionizer.ledger.read.service.AccountDetailService;
import com.abstractionizer.ledger.read.storage.rmdb.mapper.AccountDetailMapper;
import com.abstractionizer.module.exception.BusinessException;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.abstractionizer.module.error.Error.UPDATE_DATA_FAILED;

@Service
public class AccountDetailServiceImpl implements AccountDetailService {

    private final AccountDetailMapper accountDetailMapper;

    public AccountDetailServiceImpl(AccountDetailMapper accountDetailMapper) {
        this.accountDetailMapper = accountDetailMapper;
    }

    @Override
    public void modifyState(@NotNull final ModifyAccountDetailStateDto dto) {
        if(accountDetailMapper.modifyState(dto.getAccountId(), dto.getAccountState()) != 1){
            throw new BusinessException(UPDATE_DATA_FAILED);
        }
    }

    @Override
    public List<AccountAndWalletDetailVo> getAccountAndWalletDetails(@NonNull final Long entityId) {
        return accountDetailMapper.selectAccountAndWalletDetailsByEntityId(entityId);
    }
}
