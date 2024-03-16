package com.abstractionizer.ledger.read.mq.rabbit;

import com.abstractionizer.ledger.read.model.dto.WalletBalanceUpdateDto;
import com.abstractionizer.ledger.read.service.WalletDetailService;
import com.abstractionizer.module.rabbitmq.BaseRabbitListener;
import com.rabbitmq.client.Channel;
import jakarta.validation.Valid;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static com.abstractionizer.ledger.read.mq.rabbit.config.WalletDetailConfig.WALLET_DETAIL_BALANCE_UPDATE_QUEUE;

@Component
public class WalletDetailListener extends BaseRabbitListener {

    private final WalletDetailService walletDetailService;

    public WalletDetailListener(WalletDetailService walletDetailService) {
        this.walletDetailService = walletDetailService;
    }

    @RabbitListener(queues = WALLET_DETAIL_BALANCE_UPDATE_QUEUE, containerFactory = "containerFactory", concurrency = "5")
    public void walletDetailBalanceUpdate(@Payload @Valid Message<WalletBalanceUpdateDto> message, Channel channel){
        processMessage(message, channel,() -> walletDetailService.updateBalance(message.getPayload()));
    }
}
