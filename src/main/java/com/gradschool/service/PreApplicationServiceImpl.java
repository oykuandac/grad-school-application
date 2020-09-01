package com.gradschool.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gradschool.model.Application;
import com.gradschool.model.PreApplication;
import com.gradschool.model.User;
import com.gradschool.repository.ApplicationRepository;
import com.gradschool.repository.PreApplicationRepository;
import com.gradschool.repository.UserRepository;

@Service
public class PreApplicationServiceImpl {
	
	@Autowired
	private PreApplicationRepository preApplicationRepository;
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SecurityServiceImpl securityServiceImpl;

	@Transactional
	public void save(PreApplication preApplication) {
		
		String s =securityServiceImpl.findLoggedInUsername();
		User user = userRepository.findByEmail(s);
		List<Application> applications = applicationRepository.findByUser(user);
		
		for(Application app: applications ) {
			if(app.getPreApplication() == null) {
				app.setPreApplication(preApplication);
				preApplicationRepository.save(preApplication);
				break;
			}
		}
		
	}
	
	public PreApplication findById(long id) {
		return preApplicationRepository.findById(id)
				.orElse(null);
	}
	
	public void update(long id,PreApplication preApplication) {
		PreApplication preApp = preApplicationRepository.findById(id)
										.orElse(null);
		preApp.setAddress(preApplication.getAddress());
		preApp.setAles(preApplication.getAles());
		preApp.setBirthDate(preApplication.getBirthDate());
		preApp.setCitizen(preApplication.getCitizen());
		preApp.setDegree(preApplication.getDegree());
		preApp.setDept(preApplication.getDept());
		preApp.setGender(preApplication.getGender());
		preApp.setGpa(preApplication.getGpa());
		preApp.setName(preApplication.getName());
		preApp.setNationality(preApplication.getNationality());
		preApp.setNumber(preApplication.getNumber());
		preApp.setSurName(preApplication.getSurName());
		preApp.setTcno(preApplication.getTcno());
		preApp.setUniversity(preApplication.getUniversity());
		preApp.setWorking(preApplication.getWorking());
		preApplicationRepository.save(preApp);
	}
	
	public PreApplication findByAppId(long appId) {
		Application app = applicationRepository.findById(appId)
							.orElse(null);
		return app.getPreApplication();
		
	}
}
