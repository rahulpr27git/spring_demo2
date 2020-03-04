package com.cbnits.spring_demo2.resources.entity.embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "address")
    private String address;

    @Column(name = "zip_code")
    private Integer zipCode;

    public Address() {
    }

    public Address(String address, Integer zipCode) {
        this.address = address;
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }
}
