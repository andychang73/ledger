package com.abstractionizer.module.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.rabbitmq.client.Channel;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.Objects;
import java.util.Optional;

@Slf4j
public class BaseRabbitListener {

    @SneakyThrows
    protected void processMessage(@NonNull final Message<?> message, @NonNull final Channel channel,
                                  @NonNull final RabbitMessageProcessor processor) {

        Long tag = null;
        boolean multiple = false;
        boolean requeue = false;

        try {

            MessageHeaders headers = message.getHeaders();
            tag = Optional.ofNullable(headers.get(AmqpHeaders.DELIVERY_TAG, Long.class)).orElseThrow(() -> new RuntimeException("No tags!!!"));

            processor.doBusinessLogic();

            channel.basicAck(tag, multiple);
        } catch (Exception e) {
            log.error("", e);
            if (Objects.nonNull(tag)) {
                channel.basicNack(tag, multiple, requeue);
            }
        }
    }

    public interface RabbitMessageProcessor {
        void doBusinessLogic() throws JsonProcessingException;
    }

}
