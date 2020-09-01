package com.gradschool.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gradschool.model.Application;
import com.gradschool.model.Interview;
import com.gradschool.model.PreApplication;
import com.gradschool.model.User;
import com.gradschool.repository.RoleRepository;
import com.gradschool.service.ApplicationServiceImpl;
import com.gradschool.service.GradOperationsServiceImpl;
import com.gradschool.service.UserServiceImpl;

@Controller
public class ApplicationController {
	
	@Autowired
    private ApplicationServiceImpl applicationServiceImpl;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
    @Autowired
	private HttpServletRequest httpServletRequest ;
			
    @Autowired
    private GradOperationsServiceImpl gradOperationsService;
    
	
    @GetMapping("/application")
    public String application() {
    	if(!gradOperationsService.getOperations().isAppsStartStop()) {
    		httpServletRequest.setAttribute("isStart", "false");
    		return "jsp/application";
    	}
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	System.out.println(auth.getPrincipal());
    	User user = userServiceImpl.findByUsername(auth.getName());
    	List<Application> applications = applicationServiceImpl.getGivenUsersApplications(user);
    	for(Application application: applications) {
    		if(application.getPreApplication() == null)
    			return "jsp/application";
    	}
    	        
    	java.util.Date date = new java.util.Date();    	
        Application application = new Application();
        application.setDate(date);
        application.setAccepted(false);
        application.setConfirmed(false);
        application.setPreApplication(null);
        application.setUser(user);
        applicationServiceImpl.save(application);
        return "jsp/application";
    }
	
	@PostMapping("application/add")
    public String registration(@ModelAttribute Application application) {
        applicationServiceImpl.save(application);
        return "jsp/preApplication";
    }
	
	
	@PostMapping("application/setIsConfirm")
    public ResponseEntity<String> updateIsConfirmed(@RequestParam long appId,  @RequestParam boolean isConfirm) {
        applicationServiceImpl.setIsConfirmed(appId, isConfirm);
        return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);

    }
	@PostMapping("application/setIsVerified")
    public ResponseEntity<String> updateIsVerified(@RequestParam long appId,  @RequestParam boolean isVerify) {
        applicationServiceImpl.setIsVerified(appId, isVerify);
        return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);

    }
	
	
	
	//WontWork
	@RequestMapping("application/getAll")
	public String getAllApplications() {
		List<Application> list = applicationServiceImpl.getAll();
		httpServletRequest.setAttribute("list", list); 	
		httpServletRequest.setAttribute("size", list.size());
		return "jsp/deneme2";
	}
	
	@GetMapping("applications/findAppById")
	@ResponseBody
	public Application findById(long id) {
		return applicationServiceImpl.findOne(id);
	}
	
	@GetMapping("applications/grad/findAppById")
	@ResponseBody
	public Application findByIdGrad(long id) {
		return applicationServiceImpl.findOne(id);
	}
	
	@PostMapping("/deliverApplicationsToDepartment")
	public ResponseEntity<String> deliver() {
		System.out.println("A");
		this.gradOperationsService.deliver();
        return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/announceResults")
	public ResponseEntity<String> announceResults() {
		System.out.println("A");
		this.gradOperationsService.announceResults();
        return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/finishComfirmation")
	public ResponseEntity<String> finishComfirmation(HttpServletResponse res) throws IOException {
		this.gradOperationsService.finishComfirmation();
		res.sendRedirect("/home");
        return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);
	}	
	
	@PostMapping("/finishVerification")
	public ResponseEntity<String> finishVerification(HttpServletResponse res) throws IOException {
		this.gradOperationsService.finishVerification();
		res.sendRedirect("/home");
        return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);
	}
	
	
	@PostMapping("/deleteApplication")
	public ResponseEntity<String> deleteAppli(@RequestParam long appId){
		System.out.println(appId);
		applicationServiceImpl.delete(appId);
        return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);
	}
	
	
	@PostMapping("/startApplications")
	public ResponseEntity<String> startApps(HttpServletResponse res) throws IOException{
		this.gradOperationsService.startApplications();
		res.sendRedirect("/accountGrad");
        return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/stopApplications")
	public ResponseEntity<String> stopApps(HttpServletResponse res) throws IOException{
		this.gradOperationsService.stopApplications();
		res.sendRedirect("/accountGrad");
        return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
	
	
}
