package com.cbnits.spring_demo2.util.exception;

import com.cbnits.spring_demo2.resources.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public final class ApiExceptionHandler {

    @ExceptionHandler(InvalidRequestException.class)
    public final ResponseEntity<ErrorResponse> handleInvalidRequest(InvalidRequestException e) {
        return new ResponseEntity<>(
                new ErrorResponse(
                        e.getMessage(),
                        HttpStatus.BAD_REQUEST.toString(),
                        LocalDateTime.now().toString()
                ),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ErrorResponse> handleBeanValidationError(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        String message = errors.values().toString().replace("[", "").replace("]", "");
        return new ResponseEntity<>(
                new ErrorResponse(
                        message,
                        HttpStatus.BAD_REQUEST.toString(),
                        LocalDateTime.now().toString()
                ),
                HttpStatus.BAD_REQUEST
        );
    }
}
