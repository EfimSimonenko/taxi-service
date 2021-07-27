package com.simonenko.driverservice.repo;

import com.simonenko.driverservice.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findDriverByUsername(String username);

}
