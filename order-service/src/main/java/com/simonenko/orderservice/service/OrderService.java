package com.simonenko.orderservice.service;

import com.simonenko.orderservice.model.Order;
import com.simonenko.orderservice.model.Status;
import com.simonenko.orderservice.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order createOrder(Order order) {
        order.setStatus(Status.Unassigned);
        Order orderWithId = orderRepository.save(order);
        return orderWithId;
    }

    public Order updateOrder(long id, String username, Status status) {
         Order order = orderRepository.getById(id);
         order.setStatus(status);
         order.setDriverUsername(username);
         return orderRepository.save(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }




}
