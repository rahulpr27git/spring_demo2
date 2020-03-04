package com.cbnits.spring_demo2.resources.entity;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;

/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)*/
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    @OneToOne(mappedBy = "internDetails")
    @JsonProperty("interns")
    @JsonIgnoreProperties("address")
    private Interns interns;

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

    public Interns getInterns() {
        return interns;
    }

    public void setInterns(Interns interns) {
        this.interns = interns;
    }
}
