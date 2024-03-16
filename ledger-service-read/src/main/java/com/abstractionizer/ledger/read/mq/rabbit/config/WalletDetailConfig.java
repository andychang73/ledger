package com.abstractionizer.ledger.read.mq.rabbit.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WalletDetailConfig {

    public static final String WALLET_DETAIL_BALANCE_UPDATE_QUEUE = "ledger.read.wallet.detail.balance.update.q";
    public static final String WALLET_BALANCE_UPDATE_EXCHANGE = "ledger.write.wallet.balance.update.ex";

    @Bean("walletDetailBalanceUpdateQ")
    public Queue walletDetailBalanceUpdateQueue(){
        return QueueBuilder
                .durable(WALLET_DETAIL_BALANCE_UPDATE_QUEUE)
                .build();
    }

    @Bean("walletBalanceUpdateExchange")
    public FanoutExchange walletBalanceUpdateExchange(){
        return new FanoutExchange(WALLET_BALANCE_UPDATE_EXCHANGE);
    }

    @Bean
    public Binding walletBalanceUpdateBinding(@Qualifier("walletBalanceUpdateExchange") FanoutExchange ex,
                                              @Qualifier("walletDetailBalanceUpdateQ") Queue q){
        return BindingBuilder.bind(q).to(ex);
    }
}
