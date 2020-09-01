package com.gradschool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gradschool.model.Application;
import com.gradschool.model.Interview;
import com.gradschool.model.User;
import com.gradschool.repository.ApplicationRepository;
import com.gradschool.repository.InterviewRepository;
import com.gradschool.repository.UserRepository;


@Service
public class InterviewServiceImpl implements InterviewService {

	
	
	@Autowired
	private InterviewRepository  interviewRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SecurityServiceImpl securityServiceImpl;
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Transactional
	@Override
	public void save(Interview interview) {
		
		Application application = applicationRepository.findById(interview.getApplication().getId())
				.orElse(null);
		
		if(application.getInterview()!=null) {
			updateInterview(application.getInterview().getId(), interview);
		}else {	
			String s =securityServiceImpl.findLoggedInUsername();
			User user = userRepository.findByEmail(s);
			interview.setDepartment(user); // departmanı
			
			application.setInterview(interview);
			
			interviewRepository.save(interview);
		}
			
	}
	
	public void updateInterview(long id,Interview interview) {
		Interview interview1 = interviewRepository.findById(id)
				.orElse(null);
		interview1.setNote(interview.getNote());
		interview1.setDate(interview.getDate());
		interview1.setLocation(interview.getLocation());
		interviewRepository.save(interview1);

	}
	
	
	public List<Interview> getAll() {
		return interviewRepository.findAll();
	}
	
	
	public void setNote(long id,double note) {
		Interview interview = interviewRepository.findById(id)
                						.orElse(null);
		System.out.println(interview);
		interview.setNote(note);
		interviewRepository.save(interview);
	}
	

	@Override
	public Interview findOne(long id) {
		// TODO Auto-generated method stub
		Interview intv = interviewRepository.findById(id)
								.orElse(null);
		return intv;
	}
	
}
