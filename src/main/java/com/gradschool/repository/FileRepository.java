package com.gradschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradschool.model.File;


public interface FileRepository  extends JpaRepository<File, String> {
	
}
