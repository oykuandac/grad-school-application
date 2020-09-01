package com.gradschool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.gradschool.model.Application;
import com.gradschool.model.User;
import com.gradschool.repository.ApplicationRepository;
import com.gradschool.repository.UserRepository;

@Service
public class ApplicationServiceImpl {
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SecurityServiceImpl securityServiceImpl;
	
	public void save(Application application) {
		applicationRepository.save(application);
	}
	
	public List<Application> getAll() {
		return applicationRepository.findAll();
	}
	
	public List<Application> getAllComfirmed() {
		List<Application> apps =  applicationRepository.findAll();
		System.out.println(apps.size());
		for(int i = 0;i<apps.size();i++) {
			if(apps.get(i).isConfirmed()==false)
				apps.remove(apps.get(i));
		}
		return apps;
		
	}
	
	public List<Application> getAllVerified() {
		List<Application> apps =  applicationRepository.findAll();
		System.out.println(apps.size());
		List<Application> new_apps = new ArrayList<>();
		for(int i = 0;i<apps.size();i++) {
			if(apps.get(i).isVerifed()==true)
				new_apps.add(apps.get(i));
		}
		return new_apps;
		
	}
	
	
	public List<Application> getResults() {
		List<Application> apps =  getAllVerified();
		System.out.println(apps.size());
		List<Application> new_apps = new ArrayList<>();
		for(int i = 0;i<apps.size();i++) {
			if(apps.get(i).getPreApplication() == null && apps.get(i) == null) {
				continue;
			}
			int ales;
			int gpa;
			int interview;
			int sonuc;
			try {
				ales = Integer.parseInt(apps.get(i).getPreApplication().getAles());
				gpa = Integer.parseInt(apps.get(i).getPreApplication().getGpa());
				interview = (int)(apps.get(i).getInterview().getNote());
				sonuc = (ales*50/100)+(gpa*30/100)+(interview * 20/100);
			}catch(Exception e) {
				continue;
			}
			if(apps.get(i).isVerifed()==true&&sonuc> 60) {
				apps.get(i).setAccepted(true);
				
			}else {
				apps.get(i).setAccepted(false);
			}
			save(apps.get(i));

		}
		return apps;
		
	}
	
	
	
	
	public Page<Application> getAllPageable(Pageable pageable) {
		return applicationRepository.findAll(pageable);
	}
	
	
	public List<Application> getGivenUsersApplications(User user){
		List<Application> applications = applicationRepository.findByUser(user);
		return applications;		
	}
	
	public void setIsConfirmed(long id,Boolean isConfirmed) {
		Application app = applicationRepository.findById(id)
                						.orElse(null);
		app.setConfirmed(isConfirmed);
		applicationRepository.save(app);
	}
	
	public void setIsVerified(long id,Boolean isVerified) {
		Application app = applicationRepository.findById(id)
                						.orElse(null);
		app.setVerifed(isVerified);
		applicationRepository.save(app);
	}

	public Application findOne(long id) {
		// TODO Auto-generated method stub
		return applicationRepository.findById(id)
				.orElse(null);
	}
	public void delete(long id) {
		applicationRepository.deleteById(id);
	}
}
