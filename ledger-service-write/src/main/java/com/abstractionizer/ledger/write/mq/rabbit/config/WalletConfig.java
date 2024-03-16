package com.abstractionizer.ledger.write.mq.rabbit.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WalletConfig {

    public static final String WALLET_BALANCE_UPDATE_EXCHANGE = "ledger.write.wallet.balance.update.ex";

    @Bean
    public FanoutExchange walletBalanceUpdateExchange(){
        return new FanoutExchange(WALLET_BALANCE_UPDATE_EXCHANGE);
    }
}
