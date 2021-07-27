package com.simonenko.orderservice.repo;

import com.simonenko.orderservice.model.Order;
import com.simonenko.orderservice.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrderByStatus(Status status);

}
