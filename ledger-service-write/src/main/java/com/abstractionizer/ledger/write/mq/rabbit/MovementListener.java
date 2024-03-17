package com.abstractionizer.ledger.write.mq.rabbit;

import com.abstractionizer.ledger.write.business.MovementBusiness;
import com.abstractionizer.ledger.write.model.dto.MovementModifyDto;
import com.abstractionizer.ledger.write.model.dto.MovementMoveDto;
import com.abstractionizer.module.rabbitmq.BaseRabbitListener;
import com.rabbitmq.client.Channel;
import jakarta.validation.Valid;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.abstractionizer.ledger.write.mq.rabbit.config.MovementConfig.*;

@Component
public class MovementListener extends BaseRabbitListener {

    private final MovementBusiness movementBusiness;

    public MovementListener(MovementBusiness movementBusiness) {
        this.movementBusiness = movementBusiness;
    }

    @RabbitListener(queues = MOVEMENT_MOVE_QUEUE, containerFactory = "containerFactory", concurrency = "5")
    public void processMoveMovement(@Payload @Valid Message<List<MovementMoveDto>> message, Channel channel) {
        processMessage(message, channel, () -> message.getPayload().forEach(movementBusiness::move));
    }

    @RabbitListener(queues = MOVEMENT_MODIFY_QUEUE, containerFactory = "containerFactory", concurrency = "5")
    public void processModifyMovement(@Payload @Valid Message<MovementModifyDto> message, Channel channel) {
        processMessage(message, channel, () -> movementBusiness.modify(message.getPayload()));
    }

    @RabbitListener(queues = MOVEMENT_CANCEL_QUEUE, containerFactory = "containerFactory", concurrency = "5")
    public void processCancelMovement(@Payload @Valid Message<Long> message, Channel channel) {

    }
}
