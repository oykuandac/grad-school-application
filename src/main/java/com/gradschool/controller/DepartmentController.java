package com.gradschool.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gradschool.model.Application;
import com.gradschool.model.Interview;
import com.gradschool.service.ApplicationServiceImpl;
import com.gradschool.service.GradOperationsServiceImpl;
import com.gradschool.service.InterviewServiceImpl;
import com.gradschool.service.UserServiceImpl;

@Controller
public class DepartmentController {

	
	@Autowired
	private InterviewServiceImpl interviewService;
	
	@Autowired
	private ApplicationServiceImpl applicationService;
	
	@Autowired
	private UserServiceImpl userService;
	
    @Autowired
	private HttpServletRequest httpServletRequest;
    
    @Autowired
    private GradOperationsServiceImpl gradOperationsService;
    
	@RequestMapping("/getAllInterviews")
	public String getAllInterviews(Model model) {
		List<Interview> data = new ArrayList<Interview>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());
		String deptName = userService.findByUsername(auth.getName()).getName();
		
		for(Interview interview: interviewService.getAll()) {
			if(interview.getDepartment().getName().equals(deptName)) {
				data.add(interview);
			}
		}
		
		
		model.addAttribute("data",data);
    	return "thymeleaf/interview";
	}
	
	
	@RequestMapping("applications/getAll")
	public String getAllApplications(Model model) {
		List<Application> data = new ArrayList<Application>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());
		String deptName = userService.findByUsername(auth.getName()).getName();
		
		if(gradOperationsService.getOperations().isDeliverApps() == false) {
			return "thymeleaf/seeApplicationsError";
		}
				
		for(Application app: applicationService.getAllVerified()) {
			if(app != null && app.getPreApplication() != null) {
				if(app.getPreApplication().getDept().equals(deptName)) {
					data.add(app);
				}
			}
		}		
		model.addAttribute("data",data);
		
    	return "thymeleaf/appsDept";
	}
	
	@PostMapping("/deliverInerviewsToGrad")
	public ResponseEntity<String> deliverInts() {
		System.out.println("A");
		this.gradOperationsService.deliverInterviews();
        return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/deliverNotesToGrad")
	public ResponseEntity<String> deliverNotes() {
		System.out.println("A");
		this.gradOperationsService.deliverNotes();
        return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);
	}
	
	
	
}
