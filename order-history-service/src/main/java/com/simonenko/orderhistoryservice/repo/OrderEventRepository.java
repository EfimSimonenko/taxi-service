package com.simonenko.orderhistoryservice.repo;

import com.simonenko.orderhistoryservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderEventRepository extends JpaRepository<Order, Long> {
    List<Order> getOrderEventByDriverUsername(String username);
}
