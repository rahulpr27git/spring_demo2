package com.cbnits.spring_demo2.api;

import com.cbnits.spring_demo2.resources.entity.Interns;
import com.cbnits.spring_demo2.resources.request.InternRequest;
import com.cbnits.spring_demo2.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("v1/interns")
public class InternController {

    @Autowired
    private InternService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Interns create(@RequestBody @Valid InternRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public Interns update(
            @PathVariable("id") Long id,
            @RequestBody InternRequest request
    ) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Interns get(@PathVariable("id") Long id) {
        return service.get(id);
    }
}
