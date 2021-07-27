package com.simonenko.customerservice.service;


import com.simonenko.customerservice.model.Client;
import com.simonenko.customerservice.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public boolean userExists(String username) {
        return clientRepository.findClientByUsername(username).isPresent();
    }

    public Client createUser(Client client) {
        Client newClient = clientRepository.save(client);
        return newClient;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

}
