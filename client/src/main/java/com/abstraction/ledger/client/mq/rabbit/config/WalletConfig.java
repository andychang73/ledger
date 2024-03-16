package com.abstraction.ledger.client.mq.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WalletConfig {

    public static final String WALLET_BALANCE_UPDATE_EXCHANGE = "ledger.write.wallet.balance.update.ex";
    public static final String WALLET_BALANCE_UPDATE_QUEUE = "ledger.client.wallet.balance.update.q";

    @Bean("walletBalanceUpdateQ")
    public Queue walletBalanceUpdateQueue(){
        return QueueBuilder
                .durable(WALLET_BALANCE_UPDATE_QUEUE)
                .build();
    }

    @Bean("walletBalanceUpdateEx")
    public FanoutExchange walletBalanceUpdateExchange(){
        return new FanoutExchange(WALLET_BALANCE_UPDATE_EXCHANGE);
    }

    @Bean
    public Binding walletBalanceUpdateBinding(@Qualifier("walletBalanceUpdateQ") Queue q,
                                              @Qualifier("walletBalanceUpdateEx") FanoutExchange ex){
        return BindingBuilder.bind(q).to(ex);
    }
}
