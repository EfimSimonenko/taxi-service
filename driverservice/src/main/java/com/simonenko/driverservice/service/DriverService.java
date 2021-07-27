package com.simonenko.driverservice.service;

import com.simonenko.driverservice.model.Driver;
import com.simonenko.driverservice.repo.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public boolean driverExists(String username) {
        return driverRepository.findDriverByUsername(username).isPresent();
    }

    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public List<Driver> getAllClients() {
        return driverRepository.findAll();
    }

}
