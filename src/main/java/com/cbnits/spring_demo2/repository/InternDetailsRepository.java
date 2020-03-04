package com.cbnits.spring_demo2.repository;

import com.cbnits.spring_demo2.resources.entity.InternDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternDetailsRepository extends JpaRepository<InternDetails, Long> {
}
