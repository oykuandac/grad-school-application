package com.gradschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradschool.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    
}
