package com.gradschool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gradschool.model.Application;
import com.gradschool.model.User;

public interface ApplicationRepository extends JpaRepository<Application, Long>{
	
	List<Application> findByUser(User user);
		
}
