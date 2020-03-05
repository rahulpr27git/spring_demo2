package com.cbnits.spring_demo2.service;

import com.cbnits.spring_demo2.repository.InternDetailsRepository;
import com.cbnits.spring_demo2.repository.InternRepository;
import com.cbnits.spring_demo2.resources.entity.InternDetails;
import com.cbnits.spring_demo2.resources.entity.Interns;
import com.cbnits.spring_demo2.resources.entity.embeddable.Address;
import com.cbnits.spring_demo2.resources.request.InternDetailsRequest;
import com.cbnits.spring_demo2.util.exception.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InternDetailsService {

    private InternRepository repository;
    private InternDetailsRepository detailsRepository;

    @Autowired
    public InternDetailsService(InternRepository repository, InternDetailsRepository detailsRepository) {
        this.repository = repository;
        this.detailsRepository = detailsRepository;
    }

    public Interns create(InternDetailsRequest request) {

        Address address = new Address(
                request.getAddress(),
                request.getZipCode()
        );
        InternDetails details = new InternDetails(address);

        Optional<Interns> optionalInterns = repository.findById(request.getId());

        if (!optionalInterns.isPresent())
            throw new InvalidRequestException(String.format("No intern found with id: %s", request.getId()));

        Interns interns = optionalInterns.get();

        interns.setInternDetails(details);
        return repository.save(interns);
    }

    public InternDetails get(Long id) {
        Optional<InternDetails> optionalInternDetails = detailsRepository.findById(id);

        if (!optionalInternDetails.isPresent())
            throw new InvalidRequestException(String.format("No intern details found with id: %s", id));

        return optionalInternDetails.get();
    }

    /*public Interns delete(Long id) {
        return null;
    }*/
}
