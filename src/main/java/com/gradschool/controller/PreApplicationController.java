package com.gradschool.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gradschool.model.Application;
import com.gradschool.model.File;
import com.gradschool.model.PreApplication;
import com.gradschool.model.User;
import com.gradschool.service.ApplicationServiceImpl;
import com.gradschool.service.GradOperationsServiceImpl;
import com.gradschool.service.PreApplicationServiceImpl;
import com.gradschool.service.UserServiceImpl;

@Controller
public class PreApplicationController {
	
	@Autowired
	private PreApplicationServiceImpl preApplicationServiceImpl;
	
    @Autowired
    private GradOperationsServiceImpl gradOperationsService;
    
    @Autowired
    private ApplicationServiceImpl applicationServiceImpl;
    
    @Autowired
    private UserServiceImpl userServiceImpl;
	
	
    @GetMapping("/preApplication")
    public String registration(Model model, HttpServletResponse res) throws IOException {
    	if(gradOperationsService.getOperations().isAppsStartStop() == false) {
    		res.sendRedirect("/application");	
    	}
    	System.out.println("asfsafsa");
        model.addAttribute(new PreApplication());
        return "jsp/preApplication";
    }
	
	@PostMapping("/preApplication")
    public String registration(@ModelAttribute PreApplication preApplication, HttpServletRequest req, HttpServletResponse res) throws IOException {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
   		String name =auth.getName();
   		User user = userServiceImpl.findByUsername(name);
   		
   		String msg = "yes";
   		for(Application app : applicationServiceImpl.getGivenUsersApplications(user)) {
   			if(app.getPreApplication() != null) {
	   			if(app.getPreApplication().getDept().equals(preApplication.getDept())) {
	   				msg = "You Cannot Apply To Same Department Twice";
	   			}
   			}
   		}
   	
   		req.setAttribute("msg", msg);   	
   		
   		
   		if(msg.equals("yes")) {
   			preApplicationServiceImpl.save(preApplication);
   		}else {
   			res.sendRedirect("/preApplicationError");
   		}
        return "jsp/indexupload";
    }
	
	@GetMapping("/update/preApplication")
    public String updatePre(Model model, @RequestParam long preAppId) {
		PreApplication preApp = preApplicationServiceImpl.findById(preAppId);
		model.addAttribute("preApp", preApp);
		return "thymeleaf/updatePreApp";
    }
	
	@PostMapping("/update/preApplication")
    public ResponseEntity<String> updatePreApp(@RequestParam long preAppId,@ModelAttribute PreApplication preApplication, 
    	HttpServletRequest req,HttpServletResponse res) throws IOException {
		preApplicationServiceImpl.update(preAppId, preApplication);
		res.sendRedirect("/account");
		return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);		

    }
	
	@GetMapping("/preApplicationError")
	public String preAppError() {
		return "thymeleaf/preApplicationError";
	}
	
	@GetMapping("/findPreAppByAppId")
	@ResponseBody
	public PreApplication findByAppIdApplication(long id) {
		
		return preApplicationServiceImpl.findByAppId(id);
	}
	
	

}
