package com.cbnits.spring_demo2.resources.entity;

import com.cbnits.spring_demo2.resources.entity.embeddable.Address;
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

    @Embedded
    private Address address;

    @OneToOne(mappedBy = "internDetails")
    @JsonProperty("interns")
    @JsonIgnoreProperties("address")
    private Interns interns;

    public InternDetails() {
    }

    public InternDetails(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Interns getInterns() {
        return interns;
    }

    public void setInterns(Interns interns) {
        this.interns = interns;
    }
}
