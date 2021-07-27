package com.simonenko.orderservice.messaging;

import com.simonenko.orderservice.model.Order;
import com.simonenko.orderservice.web.OrderController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class KafkaOrderEventProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);


    public KafkaTemplate<String, Order> kafkaTemplate;

    public KafkaOrderEventProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Order order) {
        kafkaTemplate.send("test", order).addCallback(
                new ListenableFutureCallback<SendResult<String, Order>>() {
                    @Override
                    public void onFailure(Throwable ex) {
                        LOGGER.error("Failure while sending message in kafka.", ex);
                    }

                    @Override
                    public void onSuccess(SendResult<String, Order> result) {
                        LOGGER.info("Successfully sent message to kafka");
                    }

                });
    }



}
