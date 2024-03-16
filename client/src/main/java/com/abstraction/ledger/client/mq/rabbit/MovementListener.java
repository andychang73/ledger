package com.abstraction.ledger.client.mq.rabbit;

import com.abstraction.ledger.client.model.dto.MovementBroadCastDto;
import com.abstractionizer.module.rabbitmq.BaseRabbitListener;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.abstraction.ledger.client.mq.rabbit.config.MovementConfig.MOVEMENT_BROADCAST_QUEUE;

@Slf4j
@Component
public class MovementListener extends BaseRabbitListener {

    private final ObjectMapper objectMapper;

    public MovementListener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @RabbitListener(queues = MOVEMENT_BROADCAST_QUEUE, containerFactory = "containerFactory", concurrency = "3")
    public void listenToMovementBroadcast(@Payload @Valid Message<MovementBroadCastDto> message, Channel channel){
        processMessage(message, channel, () -> log.info("movement broadcast listener: {}", objectMapper.writeValueAsString(message.getPayload())));
    }
}
