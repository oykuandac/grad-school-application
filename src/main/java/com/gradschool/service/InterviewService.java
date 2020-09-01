package com.gradschool.service;

import java.util.List;

import com.gradschool.model.Interview;

public interface InterviewService {

	
    void save(Interview interview);
    
    void setNote(long id,double note);

    //Interview findByUsername(String username);
    
    Interview findOne(long id);
    
    public void updateInterview(long id,Interview interview); 
    
    List<Interview> getAll();
}
