package com.cbnits.spring_demo2.resources.entity;

import javax.persistence.*;

@Entity
@Table(name = "intern_details")
public class InternDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "zip_code")
    private Integer zipCode;

    public InternDetails() {
    }

    public InternDetails(String address, Integer zipCode) {
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
