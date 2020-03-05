package com.cbnits.spring_demo2.resources.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class ErrorResponse {

    @JsonProperty("message")
    private String message;

    @JsonProperty("error")
    private String errorType;

    @JsonProperty("time")
    private String time;
}
