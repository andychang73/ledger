package com.abstractionizer.ledger.write.business.impl;

import com.abstractionizer.ledger.write.business.AccountBusiness;
import com.abstractionizer.ledger.write.model.dto.ModifyAccountStateDto;
import com.abstractionizer.ledger.write.service.AccountService;
import com.abstractionizer.ledger.write.storage.rmdb.entity.AccountEntity;
import jakarta.validation.constraints.NotNull;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class AccountBusinessImpl implements AccountBusiness {


    private final AccountService accountService;
    private final RabbitTemplate rabbitTemplate;

    public AccountBusinessImpl(AccountService accountService, RabbitTemplate rabbitTemplate) {
        this.accountService = accountService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void modifyAccountState(@NotNull final ModifyAccountStateDto dto) {

        AccountEntity account = accountService.selectByIdOrThrow(dto.getAccountId());

        accountService.updateAccountState(account.getId(), dto.getAccountState());

        rabbitTemplate.convertAndSend("", "ledger.read.account.detail.q", dto);
    }
}
