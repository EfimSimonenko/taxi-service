package com.simonenko.orderhistoryservice.messaging;

import com.simonenko.orderhistoryservice.model.Order;
import com.simonenko.orderhistoryservice.service.OrderEventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaOrderEventsConsumer {

    @Autowired
    OrderEventService orderEventService;

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaOrderEventsConsumer.class);

    @KafkaListener(topics = "test", groupId = "{spring.kafka.consumer.group-id}")
    public void listenGroupFoo(Order orderEvent) {
        LOGGER.info("Received kafka message for order with id :{id}", orderEvent.getId());
        orderEventService.saveEvent(orderEvent);
    }

}
