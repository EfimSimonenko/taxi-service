package com.simonenko.customerservice.web;


import com.simonenko.customerservice.model.Client;
import com.simonenko.customerservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        if (!clientService.userExists(client.getUsername()))
        return clientService.createUser(client);
        else return null;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

}
