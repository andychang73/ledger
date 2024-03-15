package com.abstractionizer.ledger.write.service.impl;

import com.abstractionizer.ledger.write.service.AccountService;
import com.abstractionizer.ledger.write.storage.rmdb.entity.AccountEntity;
import com.abstractionizer.ledger.write.storage.rmdb.mapper.AccountMapper;
import com.abstractionizer.module.enumeration.AccountState;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountEntity selectByIdOrThrow(@NonNull final Long accountId) {
        return Optional.ofNullable(accountMapper.findById(accountId)).orElseThrow(() -> new RuntimeException(String.format("Invalid account id '%s'", accountId)));
    }

    @Override
    public void updateAccountState(@NotNull final Long id, @NotNull final AccountState state) {
        if(accountMapper.updateAccountStatus(id, state) != 1){
            throw new RuntimeException(String.format("Failed to update account id '%s', state '%s'", id, state));
        }
    }
}
