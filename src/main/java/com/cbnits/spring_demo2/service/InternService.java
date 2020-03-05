package com.cbnits.spring_demo2.service;

import com.cbnits.spring_demo2.repository.InternRepository;
import com.cbnits.spring_demo2.resources.entity.Interns;
import com.cbnits.spring_demo2.resources.request.InternRequest;
import com.cbnits.spring_demo2.util.exception.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class InternService {

    @Autowired
    private InternRepository repository;

    public Interns create(InternRequest request) {
        Interns interns = new Interns(
                request.getFirstName(),
                request.getLastName(),
                request.getGender(),
                LocalDateTime.now()
        );

        return repository.save(interns);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Interns update(Long id, InternRequest request) {

        Interns interns = repository.getOne(id);
        interns.setFirstName(request.getFirstName());
        return repository.save(interns);
    }

    public Interns get(Long id) {
        Optional<Interns> optionalInterns = repository.findById(id);

        if (!optionalInterns.isPresent())
            throw new InvalidRequestException(String.format("No intern found with id: %s", id));

        return optionalInterns.get();
    }
}
