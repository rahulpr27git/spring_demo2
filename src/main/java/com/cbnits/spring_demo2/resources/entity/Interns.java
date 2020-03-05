package com.cbnits.spring_demo2.resources.entity;

import com.cbnits.spring_demo2.resources.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)*/
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "interns")
public class Interns {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonProperty("first_name")
    @Column(name = "first_name")
    private String firstName;

    @JsonProperty("last_name")
    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    @JsonProperty("gender")
    private Gender gender;

    @Column(name = "time")
    @JsonProperty("time")
    private LocalDateTime dateTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "intern_details_relation",
            joinColumns = {
                    @JoinColumn(name = "intern_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "details_id", referencedColumnName = "id")
            }
    )
    @JsonProperty("details")
    @JsonIgnoreProperties("interns")
    private InternDetails internDetails;

    public Interns(String firstName, String lastName, Gender gender, LocalDateTime dateTime) {
       this(firstName, lastName, gender, dateTime, null);
    }

    public Interns(String firstName, String lastName, Gender gender, LocalDateTime dateTime, InternDetails internDetails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateTime = dateTime;
        this.internDetails = internDetails;
    }
}
