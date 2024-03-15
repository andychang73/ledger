package com.abstractionizer.ledger.write.mq.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfig {

    public static final String ACCOUNT_STATE_QUEUE = "ledger.write.account.state.q";

    @Bean("accountStateQ")
    public Queue accountStateQueue(){
        return QueueBuilder
                .durable(ACCOUNT_STATE_QUEUE)
                .build();
    }
}
