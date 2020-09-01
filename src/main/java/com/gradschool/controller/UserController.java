package com.gradschool.controller;

import com.gradschool.model.User;
import com.gradschool.service.ApplicationServiceImpl;
import com.gradschool.service.GradOperationsServiceImpl;
import com.gradschool.service.UserService;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
   
    @Autowired
	private HttpServletRequest httpServletRequest ;
    
    @Autowired
    private ApplicationServiceImpl applicationService;
    
    @Autowired
    private GradOperationsServiceImpl gradOperationsService;

    @GetMapping("/register")
    public String registration(Model model, HttpServletResponse response) throws IOException {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
   		String name =auth.getName();
   		if(!name.equals("anonymousUser")){
   			response.sendRedirect("/index");
   		}
        model.addAttribute(new User());
        return "jsp/register";
    }
    

    @PostMapping("/register")
    public String registration(@ModelAttribute User user, HttpServletResponse response) throws IOException {
    	if(userService.findByUsername(user.getEmail())==null) {
            userService.save(user);
            response.sendRedirect("/index");
    	}
       	String message =user.getEmail()+" has already registered, registration failed";
    	httpServletRequest.setAttribute("message", message); 
    	return "jsp/register";

    }

    @GetMapping("/login")
    public String login(Model model, HttpServletResponse response,@RequestParam(required=false) boolean loginFailed) throws IOException {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
   		String name =auth.getName();
   		if(!name.equals("anonymousUser")) {
   			User user = userService.findByUsername(auth.getName());
   			String role = user.getRoles().getName();
   			if(role.equals("User")) 
   				response.sendRedirect("/index");
   				
   			if(role.equals("Department"))
   				response.sendRedirect("/accountDept");
   			
   			if(role.equals("Gradschool"))
   				response.sendRedirect("/accountGrad");
   		}
   			
   		if(loginFailed) {
   			httpServletRequest.setAttribute("fail", "***Password or email is wrong!");
   		}
   		else {
   			httpServletRequest.setAttribute("fail", "");
   		}
   		
   		
        return "thymeleaf/login";
        
    }
    
    
    
    @GetMapping({"/", "/index","/home"})
    public String index(Model model, HttpServletResponse response) throws IOException {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if(auth.getName().equals("anonymousUser"))return "jsp/index"; 
    	User user = userService.findByUsername(auth.getName());
    	
    	if(user.getRoles().getName().equals("Department"))
    		response.sendRedirect("/accountDept");
    	
    	if(user.getRoles().getName().equals("Gradschool"))
    		response.sendRedirect("/accountGrad");
    	
       	String message =user.getName();
    	httpServletRequest.setAttribute("username", message); 		
    	return "jsp/index";    	
    }
    
    
    @RequestMapping("/seeResults")
    public String seeResults() {
    	
    	if(gradOperationsService.getOperations().isResultAnnouncement() == false) {
    		return "thymeleaf/seeResultsError";
    	}
    	httpServletRequest.setAttribute("data", applicationService.getResults());
    	return "thymeleaf/seeResults";
    }
    

	@RequestMapping(method=RequestMethod.GET, value="/all")
	  public @ResponseBody Iterable<User> getAllUsers() {
	    // This returns a JSON or XML with the users
	    return userService.getAll();
	  }
	

	
	
	
	
}