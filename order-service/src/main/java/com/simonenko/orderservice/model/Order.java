package com.simonenko.orderservice.model;

import javax.persistence.*;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "client_username")
    private String clientUsername;

    @Column(name = "address_from")
    private String addressFrom;

    @Column(name = "address_to")
    private String addressTo;

    @Column(name = "driver_username")
    private String driverUsername;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Order() {
    }

    public Order(long id, String clientUsername, String addressFrom, String addressTo, String driverUsername, Status status) {
        this.id = id;
        this.clientUsername = clientUsername;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.driverUsername = driverUsername;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    public String getDriverUsername() {
        return driverUsername;
    }

    public void setDriverUsername(String driverUsername) {
        this.driverUsername = driverUsername;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
