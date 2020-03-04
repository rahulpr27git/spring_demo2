package com.cbnits.spring_demo2.service;

import com.cbnits.spring_demo2.repository.InternDetailsRepository;
import com.cbnits.spring_demo2.repository.InternRepository;
import com.cbnits.spring_demo2.resources.entity.InternDetails;
import com.cbnits.spring_demo2.resources.entity.Interns;
import com.cbnits.spring_demo2.resources.entity.embeddable.Address;
import com.cbnits.spring_demo2.resources.request.InternDetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InternDetailsService {

    @Autowired
    private InternRepository repository;

    @Autowired
    private InternDetailsRepository detailsRepository;

    public Interns create(InternDetailsRequest request) {


        Address address = new Address(
                request.getAddress(),
                request.getZipCode()
        );
        InternDetails details = new InternDetails(address);

        Optional<Interns> optionalInterns = repository.findById(request.getId());
        Interns interns = optionalInterns.get();

        interns.setInternDetails(details);
        return repository.save(interns);
    }

    public InternDetails get(Long id) {
        return detailsRepository.findById(id).get();
    }

    /*public Interns delete(Long id) {
        return null;
    }*/
}
