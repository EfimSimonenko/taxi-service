package com.simonenko.driverservice.web;


import com.simonenko.driverservice.model.Driver;
import com.simonenko.driverservice.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/drivers")
public class DriverController {

    @Autowired
    DriverService driverService;

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllClients();
    }

    @PostMapping
    public Driver createDriver(@RequestBody Driver driver) {
        return driverService.createDriver(driver);
    }

}
