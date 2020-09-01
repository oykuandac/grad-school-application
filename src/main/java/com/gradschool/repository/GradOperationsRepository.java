package com.gradschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradschool.model.GradOperations;

public interface GradOperationsRepository extends JpaRepository< GradOperations, Long> {

}
