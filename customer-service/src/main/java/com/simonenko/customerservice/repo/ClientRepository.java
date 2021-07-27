package com.simonenko.customerservice.repo;

import com.simonenko.customerservice.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findClientByUsername(String username);


}
