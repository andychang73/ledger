package com.abstractionizer.ledger.read.service.impl;

import com.abstractionizer.ledger.read.model.dto.ModifyAccountDetailStateDto;
import com.abstractionizer.ledger.read.model.vo.AccountAndWalletDetailVo;
import com.abstractionizer.ledger.read.service.AccountDetailService;
import com.abstractionizer.ledger.read.storage.rmdb.mapper.AccountDetailMapper;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountDetailServiceImpl implements AccountDetailService {

    private final AccountDetailMapper accountDetailMapper;

    public AccountDetailServiceImpl(AccountDetailMapper accountDetailMapper) {
        this.accountDetailMapper = accountDetailMapper;
    }

    @Override
    public void modifyState(@NotNull final ModifyAccountDetailStateDto dto) {
        if(accountDetailMapper.modifyState(dto.getAccountId(), dto.getAccountState()) != 1){
            throw new RuntimeException(String.format("Failed to modify account id '%s', state '%s'", dto.getAccountId(), dto.getAccountState()));
        }
    }

    @Override
    public List<AccountAndWalletDetailVo> getAccountAndWalletDetails(@NonNull final Long entityId) {
        return accountDetailMapper.selectAccountAndWalletDetailsByEntityId(entityId);
    }
}
