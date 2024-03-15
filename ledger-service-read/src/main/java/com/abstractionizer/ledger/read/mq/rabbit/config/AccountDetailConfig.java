package com.abstractionizer.ledger.read.mq.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountDetailConfig {

    public static final String ACCOUNT_DETAIL_QUEUE = "ledger.read.account.detail.q";

    @Bean("accountDetailState")
    public Queue accountDetailState(){
        return QueueBuilder
                .durable(ACCOUNT_DETAIL_QUEUE)
                .build();
    }
}
