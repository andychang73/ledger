package com.abstractionizer.ledger.write.service;


import com.abstractionizer.ledger.write.storage.rmdb.entity.AccountEntity;
import com.abstractionizer.module.enumeration.AccountState;

public interface AccountService {

    AccountEntity selectByIdOrThrow(Long accountId);

    void updateAccountState(Long id, AccountState state);
}
