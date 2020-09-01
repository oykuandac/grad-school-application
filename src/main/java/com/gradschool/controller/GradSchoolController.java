package com.gradschool.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gradschool.model.Application;
import com.gradschool.model.Interview;
import com.gradschool.model.User;
import com.gradschool.service.ApplicationServiceImpl;
import com.gradschool.service.FileService;
import com.gradschool.service.GradOperationsServiceImpl;
import com.gradschool.service.UserServiceImpl;

@Controller
public class GradSchoolController {


	@Autowired
	private ApplicationServiceImpl applicationService;
	
	@Autowired
	private FileService fileservice;
	
    @Autowired
	private HttpServletRequest httpServletRequest ;
    
    @Autowired
    private GradOperationsServiceImpl gradOperationsService;
		
    @Autowired
    private UserServiceImpl userService;
    
    @GetMapping("/accountGrad")
    public String getAccountGrad(Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User user = userService.findByUsername(auth.getName());
       	model.addAttribute("username",user.getName());
    	model.addAttribute("data",gradOperationsService.getOperations());

    	return "thymeleaf/grad";
    }
    
    
	@RequestMapping("applications/grad/getAll")
	public String getAllApplications(Model model) {
		System.out.println(gradOperationsService.getOperations().isFinishComfirmation());
		if(gradOperationsService.getOperations().isFinishComfirmation()==false) {
			ArrayList<Application> apps = new ArrayList<Application>();
			for(Application app: applicationService.getAll()) {
				if(app.getPreApplication() != null) {
					apps.add(app);
				}
			}
			model.addAttribute("data",apps);
	    	return "thymeleaf/appsGrad";	
		}else {
			ArrayList<Application> apps2 = new ArrayList<Application>();
			for(Application app : applicationService.getAllComfirmed()) {
				if(app.getPreApplication() != null) {
					apps2.add(app);
				}
				
			}
			
			model.addAttribute("data",apps2);
	    	return "thymeleaf/appsGradVerify";
		}
			
		
	}
    
	@GetMapping("application/findOne")
	@ResponseBody
	public Application findOne(long id) {
		return applicationService.findOne(id);
	}
	
	
}
