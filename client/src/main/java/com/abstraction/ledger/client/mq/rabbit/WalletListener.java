package com.abstraction.ledger.client.mq.rabbit;

import com.abstraction.ledger.client.model.dto.SimpleWalletVo;
import com.abstractionizer.module.rabbitmq.BaseRabbitListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import jakarta.validation.Valid;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;


import static com.abstraction.ledger.client.mq.rabbit.config.WalletConfig.WALLET_BALANCE_UPDATE_QUEUE;

@Slf4j
@Configuration
public class WalletListener extends BaseRabbitListener {

    private final ObjectMapper objectMapper;

    public WalletListener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    @RabbitListener(queues = WALLET_BALANCE_UPDATE_QUEUE, containerFactory = "containerFactory", concurrency = "3")
    public void subscribeToWalletBalanceUpdate(@Payload @Valid Message<SimpleWalletVo> message, Channel channel){
        processMessage(message, channel, () -> log.info("Wallet balance update listener: {}", objectMapper.writeValueAsString(message.getPayload())));
    }
}
