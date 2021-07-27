package com.simonenko.driverservice.proxy;


import com.simonenko.driverservice.model.OrderDto;
import com.simonenko.driverservice.model.Status;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "order-service", url = "localhost:8083")
public interface OrderServiceProxy {

    @GetMapping(value = "/orders")
    List<OrderDto> getUnassignedOrders(@RequestParam(name = "driver") String username,
                                              @RequestParam Status status);

    @PutMapping(value = "/orders/{id}")
    OrderDto updateOrderStatus(@PathVariable long id, @RequestParam(name = "driver") String username,
                               @RequestParam(name = "status") Status newStatus);

}
