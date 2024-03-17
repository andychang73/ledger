package com.abstractionizer.ledger.write.service;


import com.abstractionizer.ledger.write.model.vo.WalletVo;
import com.abstractionizer.ledger.write.storage.rmdb.entity.AccountEntity;
import com.abstractionizer.module.enumeration.AccountState;

public interface AccountService {

    AccountEntity selectByIdOrThrow(Long accountId);

    void updateAccountState(Long id, AccountState state);

    void validateAccountStateIsOpen(AccountState accountState);

    WalletVo selectWalletForUpdateOrThrow(Long accountId, Long walletId);
}
