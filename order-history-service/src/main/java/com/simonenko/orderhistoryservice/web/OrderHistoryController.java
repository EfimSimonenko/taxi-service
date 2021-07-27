package com.simonenko.orderhistoryservice.web;


import com.simonenko.orderhistoryservice.model.Order;
import com.simonenko.orderhistoryservice.service.OrderEventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orderEvents")
public class OrderHistoryController {

    final OrderEventService orderEventService;

    public OrderHistoryController(OrderEventService orderEventService) {
        this.orderEventService = orderEventService;
    }


    @GetMapping
    public List<Order> getOrderHistoryForDriver(@RequestParam (name = "driver") String username) {
        return orderEventService.getOrderHistory(username);
    }
}
