package com.abstractionizer.ledger.read.mq.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovementConfig {

    public static final String MOVEMENT_BROADCAST_EXCHANGE = "ledger.write.movement.broadcast.ex";
    public static final String MOVEMENT_BROADCAST_QUEUE = "ledger.read.movement.broadcast.q";

    @Bean("movementBroadCastQ")
    public Queue movementBroadCastQueue(){
        return QueueBuilder
                .durable(MOVEMENT_BROADCAST_QUEUE)
                .build();
    }

    @Bean("movementBroadEx")
    public FanoutExchange movementBroadcastExchange(){
        return new FanoutExchange(MOVEMENT_BROADCAST_EXCHANGE);
    }

    @Bean
    public Binding movementBroadcastBinding(@Qualifier("movementBroadCastQ") Queue q,
                                            @Qualifier("movementBroadEx") FanoutExchange ex){
        return BindingBuilder.bind(q).to(ex);
    }

}
