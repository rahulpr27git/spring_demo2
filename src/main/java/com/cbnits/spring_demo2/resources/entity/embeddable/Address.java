package com.cbnits.spring_demo2.resources.entity.embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

    @Column(name = "address")
    private String address;

    @Column(name = "zip_code")
    private Integer zipCode;
}
