package com.simonenko.driverservice.web;

import com.simonenko.driverservice.exceptions.UserNotFoundException;
import com.simonenko.driverservice.model.OrderDto;
import com.simonenko.driverservice.model.Status;
import com.simonenko.driverservice.proxy.OrderServiceProxy;
import com.simonenko.driverservice.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    DriverService driverService;

    @Autowired
    OrderServiceProxy orderServiceProxy;

    @GetMapping
    public List<OrderDto> getOrders(@RequestParam(name = "driver") String username,
                                    @RequestParam Status status) {
        if (driverService.driverExists(username)) {
            return orderServiceProxy.getUnassignedOrders(username, status);
        } else {
            throw new UserNotFoundException();
        }
    }

    /*
    @PutMapping
    public OrderDto assignOrder(@PathVariable int id, @RequestParam(name = "driver") String username) {
        return orderServiceProxy.assignOrder(id, username);
    }

     */

    @PatchMapping(value = "/{id}")
    public OrderDto updateOrder(@PathVariable String id,
                                @RequestParam(name = "driver") String username,
                                @RequestParam(name = "status") Status newStatus) {
        return orderServiceProxy.updateOrderStatus(Integer.parseInt(id), username, newStatus);
    }

}
