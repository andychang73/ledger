package com.abstractionizer.ledger.write.mq.rabbit.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovementConfig {

    public static final String MOVEMENT_MOVE_QUEUE = "ledger.write.movement.move.q";
    public static final String MOVEMENT_MODIFY_QUEUE = "ledger.write.movement.modify.q";
    public static final String MOVEMENT_CANCEL_QUEUE = "ledger.write.movement.cancel.q";
    public static final String MOVEMENT_BROADCAST_EXCHANGE = "ledger.write.movement.broadcast.ex";

    @Bean("movementMoveQ")
    public Queue movementMoveQueue(){
        return QueueBuilder
                .durable(MOVEMENT_MOVE_QUEUE)
                .build();
    }

    @Bean("movementModifyQ")
    public Queue movementModifyQueue(){
        return QueueBuilder
                .durable(MOVEMENT_MODIFY_QUEUE)
                .build();
    }

    @Bean("movementCancelQ")
    public Queue movementCancelQueue(){
        return QueueBuilder
                .durable(MOVEMENT_CANCEL_QUEUE)
                .build();
    }

    @Bean
    public FanoutExchange movementBroadCastExchange(){
        return new FanoutExchange(MOVEMENT_BROADCAST_EXCHANGE);
    }
}
