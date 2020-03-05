package com.cbnits.spring_demo2.service;

import com.cbnits.spring_demo2.repository.InternDetailsRepository;
import com.cbnits.spring_demo2.repository.InternRepository;
import com.cbnits.spring_demo2.resources.request.InternDetailsRequest;
import com.cbnits.spring_demo2.util.exception.InvalidRequestException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
class InternDetailsServiceTest {

    @Test
    void create() {

        // Mockito Library

        //Mock Objects
        InternRepository internRepository = Mockito.mock(InternRepository.class);
        //Mock Objects
        InternDetailsRepository internDetailsRepository = Mockito.mock(InternDetailsRepository.class);

        //Intializing InternDetailsService with mock objects
        InternDetailsService internDetailsService = new InternDetailsService(
                internRepository, internDetailsRepository
        );

        // Creating payload to pass in create method
        InternDetailsRequest request = new InternDetailsRequest(1L, "", 42432);

        Mockito.when(internRepository.findById(request.getId()))
                .thenReturn(Optional.empty());

        InvalidRequestException exception = assertThrows(
                InvalidRequestException.class,
                () -> internDetailsService.create(request)
        );

        assertEquals("No intern found with id: 1", exception.getMessage());
    }

    @Test
    void get() {
    }
}