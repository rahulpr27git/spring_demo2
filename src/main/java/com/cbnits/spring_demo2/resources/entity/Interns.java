package com.cbnits.spring_demo2.resources.entity;

import com.cbnits.spring_demo2.resources.enums.Gender;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)*/
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
    @JoinColumn(name = "details_id")
    @JsonProperty("details")
    @JsonIgnoreProperties("interns")
    private InternDetails internDetails;

    public Interns() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public InternDetails getInternDetails() {
        return internDetails;
    }

    public void setInternDetails(InternDetails internDetails) {
        this.internDetails = internDetails;
    }
}
