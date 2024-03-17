package com.abstractionizer.ledger.read.mq.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BalanceHistoryConfig {

    public static final String BALANCE_HISTORY_UPDATE = "ledger.read.balance.history.update.q";

    @Bean("balanceHistoryUpdateQ")
    public Queue balanceHistoryUpdateQueue(){
        return QueueBuilder
                .durable(BALANCE_HISTORY_UPDATE)
                .build();
    }
}
