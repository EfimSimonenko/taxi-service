package com.simonenko.driverservice.model;

public class OrderDto {

    private long id;
    private String clientUsername;
    private String addressFrom;
    private String addressTo;
    private String driverUsername;
    private Status status;

    public OrderDto() {
    }

    public OrderDto(long id, String clientUsername, String addressFrom, String addressTo, String driverUsername, Status status) {
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
