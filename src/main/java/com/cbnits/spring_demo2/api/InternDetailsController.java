package com.cbnits.spring_demo2.api;

import com.cbnits.spring_demo2.repository.InternDetailsRepository;
import com.cbnits.spring_demo2.resources.entity.InternDetails;
import com.cbnits.spring_demo2.resources.entity.Interns;
import com.cbnits.spring_demo2.resources.request.InternDetailsRequest;
import com.cbnits.spring_demo2.service.InternDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/interns/details")
public class InternDetailsController {

    @Autowired
    private InternDetailsService service;

    @PostMapping
    public Interns create(@RequestBody InternDetailsRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public InternDetails get(@PathVariable("id") Long id) {
        return service.get(id);
    }

}
