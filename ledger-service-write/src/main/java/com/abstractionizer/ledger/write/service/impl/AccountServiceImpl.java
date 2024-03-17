package com.abstractionizer.ledger.write.service.impl;

import com.abstractionizer.ledger.write.model.vo.WalletVo;
import com.abstractionizer.ledger.write.service.AccountService;
import com.abstractionizer.ledger.write.storage.rmdb.entity.AccountEntity;
import com.abstractionizer.ledger.write.storage.rmdb.mapper.AccountMapper;
import com.abstractionizer.module.enumeration.AccountState;
import com.abstractionizer.module.exception.BusinessException;
import com.abstractionizer.module.exception.DeclineException;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.abstractionizer.module.error.Error.*;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountEntity selectByIdOrThrow(@NonNull final Long accountId) {
        return Optional.ofNullable(accountMapper.findById(accountId)).orElseThrow(() -> new BusinessException(DATA_NOT_FOUND));
    }

    @Override
    public void updateAccountState(@NonNull final Long id, @NonNull final AccountState state) {
        if(accountMapper.updateAccountStatus(id, state) != 1){
            throw new BusinessException(UPDATE_DATA_FAILED);
        }
    }

    @Override
    public void validateAccountStateIsOpen(@NonNull final AccountState accountState) {
        if(accountState != AccountState.OPEN){
            throw new DeclineException(ILLEGAL_ACCOUNT_STATE_TO_MOVE);
        }
    }

    @Override
    public WalletVo selectWalletForUpdateOrThrow(@NonNull final Long accountId, @NonNull final Long walletId) {
        return Optional.ofNullable(accountMapper.selectByIdAndWalletIdForUpdate(accountId, walletId))
                .orElseThrow(() -> new DeclineException(WALLET_NOT_FOUND));
    }
}
