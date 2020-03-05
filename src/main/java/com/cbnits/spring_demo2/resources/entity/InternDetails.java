package com.cbnits.spring_demo2.resources.entity;

import com.cbnits.spring_demo2.resources.entity.embeddable.Address;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)*/
@Data
@NoArgsConstructor
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
    @JsonIgnoreProperties("details")
    private Interns interns;

    public InternDetails(Address address) {
        this.address = address;
    }
}
