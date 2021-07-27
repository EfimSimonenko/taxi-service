package com.simonenko.orderhistoryservice.service;

import com.simonenko.orderhistoryservice.model.Order;
import com.simonenko.orderhistoryservice.repo.OrderEventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderEventService {

    final OrderEventRepository orderEventRepository;

    public OrderEventService(OrderEventRepository orderEventRepository) {
        this.orderEventRepository = orderEventRepository;
    }

    public List<Order> getOrderHistory(String username) {
        return  orderEventRepository.getOrderEventByDriverUsername(username);
    }

    public Order saveEvent(Order orderEvent) {
        return orderEventRepository.save(orderEvent);
    }

}
