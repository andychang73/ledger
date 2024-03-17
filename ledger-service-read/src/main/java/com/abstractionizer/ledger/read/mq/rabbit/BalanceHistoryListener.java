package com.abstractionizer.ledger.read.mq.rabbit;

import com.abstractionizer.ledger.read.model.vo.WalletDetailAndHistoryUpdateDto;
import com.abstractionizer.module.rabbitmq.BaseRabbitListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.abstractionizer.ledger.read.mq.rabbit.config.BalanceHistoryConfig.BALANCE_HISTORY_UPDATE;

@Slf4j
@Component
public class BalanceHistoryListener extends BaseRabbitListener {

    private final ObjectMapper objectMapper;

    public BalanceHistoryListener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = BALANCE_HISTORY_UPDATE, containerFactory = "containerFactory", concurrency = "5")
    public void balanceHistoryUpdate(@Payload @Valid Message<WalletDetailAndHistoryUpdateDto> message, Channel channel){
        processMessage(message, channel, () -> log.info("!!!: {}", objectMapper.writeValueAsString(message.getPayload())));
    }
}
