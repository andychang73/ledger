package com.abstractionizer.ledger.read.mq.rabbit;

import com.abstractionizer.ledger.read.model.dto.ModifyAccountDetailStateDto;
import com.abstractionizer.ledger.read.service.AccountDetailService;
import com.abstractionizer.module.rabbitmq.BaseRabbitListener;
import com.rabbitmq.client.Channel;
import jakarta.validation.Valid;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.abstractionizer.ledger.read.mq.rabbit.config.AccountDetailConfig.ACCOUNT_DETAIL_QUEUE;

@Component
public class AccountDetailListener extends BaseRabbitListener {

    private final AccountDetailService accountDetailService;

    public AccountDetailListener(AccountDetailService accountDetailService) {
        this.accountDetailService = accountDetailService;
    }

    @RabbitListener(queues = ACCOUNT_DETAIL_QUEUE, containerFactory = "containerFactory", concurrency = "5")
    public void modifyAccountDetailState(@Payload @Valid Message<ModifyAccountDetailStateDto> message, Channel channel){
        processMessage(message, channel, () -> accountDetailService.modifyState(message.getPayload()));
    }
}
