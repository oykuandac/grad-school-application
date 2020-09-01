package com.gradschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradschool.model.Interview;


public interface InterviewRepository extends JpaRepository<Interview, Long> {

}

