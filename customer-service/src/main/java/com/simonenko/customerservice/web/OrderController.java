package com.simonenko.customerservice.web;

import com.simonenko.customerservice.exceptions.UserNotFoundException;
import com.simonenko.customerservice.model.OrderDto;
import com.simonenko.customerservice.proxy.OrderServiceProxy;
import com.simonenko.customerservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    ClientService clientService;




    @Autowired
    OrderServiceProxy proxy;


    @PostMapping
    public OrderDto createOrder(@RequestBody OrderDto requestOrderDto) {
        if (clientService.userExists(requestOrderDto.getClientUsername())) {
            return proxy.createOrder(requestOrderDto);
        } else {
            throw new UserNotFoundException();
        }
    }
        /*
            String uri = "http://localhost:8083/orders";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<OrderDto> request = new HttpEntity<>(requestOrderDto, headers);
            OrderDto responseOrderDto = restTemplate.postForObject(uri, request, OrderDto.class);
            return responseOrderDto;

             */

}
