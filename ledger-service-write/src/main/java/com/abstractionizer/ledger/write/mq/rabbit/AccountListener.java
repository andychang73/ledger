package com.abstractionizer.ledger.write.mq.rabbit;

import com.abstractionizer.ledger.write.business.AccountBusiness;
import com.abstractionizer.ledger.write.model.dto.ModifyAccountStateDto;
import com.abstractionizer.module.rabbitmq.BaseRabbitListener;
import com.rabbitmq.client.Channel;
import jakarta.validation.Valid;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.abstractionizer.ledger.write.mq.rabbit.config.AccountConfig.ACCOUNT_STATE_QUEUE;

@Component
public class AccountListener extends BaseRabbitListener {

    private final AccountBusiness accountBusiness;

    public AccountListener(AccountBusiness accountBusiness) {
        this.accountBusiness = accountBusiness;
    }

    @RabbitListener(queues = ACCOUNT_STATE_QUEUE, containerFactory = "containerFactory")
    public void modifyAccountState(@Payload @Valid Message<ModifyAccountStateDto> message, Channel channel){
        processMessage(message, channel, () -> accountBusiness.modifyAccountState(message.getPayload()));
    }
}
