package com.cbnits.spring_demo2.repository;

import com.cbnits.spring_demo2.resources.entity.Interns;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternRepository extends JpaRepository<Interns, Long> {
}
