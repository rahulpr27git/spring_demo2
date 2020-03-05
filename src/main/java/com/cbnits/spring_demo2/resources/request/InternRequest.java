package com.cbnits.spring_demo2.resources.request;

import com.cbnits.spring_demo2.resources.enums.Gender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public final class InternRequest {

    @NotEmpty(message = "First name is required")
    @JsonProperty("first_name")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @JsonProperty("last_name")
    private String lastName;

    @NotNull(message = "Gender is required")
    @JsonProperty("gender")
    private Gender gender;
}
