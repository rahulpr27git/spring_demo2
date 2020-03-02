package com.cbnits.spring_demo2.resources.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;

public class InternDetailsRequest {

    @JsonProperty("intern_id")
    private Long id;

    @JsonProperty("address")
    private String address;

    @JsonProperty("zip_code")
    private Integer zipCode;

    public InternDetailsRequest(Long id, String address, Integer zipCode) {
        this.id = id;
        this.address = address;
        this.zipCode = zipCode;
    }

    public Long getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public Integer getZipCode() {
        return zipCode;
    }
}

