package com.simonenko.customerservice.proxy;


import com.simonenko.customerservice.model.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.core.MediaType;

@FeignClient(name = "order-service", url = "localhost:8083")
public interface OrderServiceProxy {

    @PostMapping(value = "/orders", consumes = MediaType.APPLICATION_JSON,
            produces = MediaType.APPLICATION_JSON)
    public OrderDto createOrder(@RequestBody OrderDto orderDto);


}
