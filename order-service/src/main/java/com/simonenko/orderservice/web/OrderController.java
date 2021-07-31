package com.simonenko.orderservice.web;


import com.simonenko.orderservice.messaging.KafkaOrderEventProducer;
import com.simonenko.orderservice.model.Order;
import com.simonenko.orderservice.model.Status;
import com.simonenko.orderservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @Autowired
    KafkaOrderEventProducer kafkaOrderEventProducer;

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    /*
    for testing
     */
    @GetMapping
    public List<Order> getOrders(@RequestParam(name = "driver") String username,
                                 @RequestParam Status status) {
        LOGGER.info("GET /orders");
        return orderService.getAll();
    }

    @PutMapping(value = "/{id}")
    public Order updateOrder(@PathVariable long id,
                             @RequestParam (name = "driver") String username,
                             @RequestParam(name = "status") Status newStatus) {
        LOGGER.info("PUT /orders/{id}", id);
        Order updatedOrder = orderService.updateOrder(id, username, newStatus);
        LOGGER.info("Send order update event to Kafka", id);
        kafkaOrderEventProducer.sendMessage(updatedOrder);
        return updatedOrder;
    }



}
