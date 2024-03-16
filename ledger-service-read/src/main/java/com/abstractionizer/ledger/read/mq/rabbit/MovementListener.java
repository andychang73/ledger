package com.abstractionizer.ledger.read.mq.rabbit;


import com.abstractionizer.ledger.read.model.dto.MovementBroadCastDto;
import com.abstractionizer.ledger.read.service.MovementService;
import com.abstractionizer.module.rabbitmq.BaseRabbitListener;
import com.rabbitmq.client.Channel;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.abstractionizer.ledger.read.mq.rabbit.config.MovementConfig.MOVEMENT_BROADCAST_QUEUE;

@Slf4j
@Component
public class MovementListener extends BaseRabbitListener {

    private final MovementService movementService;

    public MovementListener(MovementService movementService) {
        this.movementService = movementService;
    }

    @RabbitListener(queues = MOVEMENT_BROADCAST_QUEUE, containerFactory = "containerFactory", concurrency = "3")
    public void listenToMovementBroadcast(@Payload @Valid Message<MovementBroadCastDto> message, Channel channel){
        processMessage(message, channel, () -> movementService.insert(message.getPayload().getMovementEntity()));
    }
}
