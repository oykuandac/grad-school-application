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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gradschool.model.Application;
import com.gradschool.model.User;
import com.gradschool.service.AnnouncementServiceImpl;
import com.gradschool.service.ApplicationServiceImpl;
import com.gradschool.service.UserService;

@Controller
public class TestController {
	
	@Autowired
	ApplicationServiceImpl appser;
	
	@Autowired
	UserService userService;
	
	
    @GetMapping("/jsp")
    String jspPage(Model model,@RequestParam String name) {
        model.addAttribute("name", name);
        return "jsp/sample";
    }

    @GetMapping("/thymeleaf")
    String thymeleafPage(Model model,@RequestParam String name) {
        model.addAttribute("name", name);
        return "thymeleaf/sample";
    }
    
    @GetMapping("/apps")
    public String getapps(Model model) {
    	model.addAttribute("data",appser.getAll());
    	return "thymeleaf/sample";
    }
    
    @GetMapping("/account")
    public String getAccount(Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User user = userService.findByUsername(auth.getName());
    	ArrayList<Application> apps = new ArrayList<Application>();
    			
    	for(Application ap : appser.getGivenUsersApplications(user)) {
    		if(ap.getPreApplication() != null) {
    			apps.add(ap);
    		}
    	}
    			
    	model.addAttribute("user",user);
    	model.addAttribute("apps", apps);
    	return "thymeleaf/applicantProfil";
    }
    
    
    @GetMapping("/accountDept")
    public String getAccountDept(Model model) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	User user = userService.findByUsername(auth.getName());
       	model.addAttribute("username",user.getName());
    	return "thymeleaf/department";
    }
    
    

    
}