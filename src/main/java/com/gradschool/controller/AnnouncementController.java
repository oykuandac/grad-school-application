package com.gradschool.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gradschool.model.Announcement;
import com.gradschool.model.Application;
import com.gradschool.model.GradOperations;
import com.gradschool.service.AnnouncementServiceImpl;
import com.gradschool.service.GradOperationsServiceImpl;

@Controller
public class AnnouncementController {

	
	@Autowired
	private AnnouncementServiceImpl announcementService;

    @Autowired
    private HttpServletRequest servletRequest;

    @Autowired
    private GradOperationsServiceImpl gradOperations;
    
    @GetMapping("/news")
    public String news() {
    	ArrayList<Announcement> data = new ArrayList<Announcement>();
    	int size = announcementService.getAll().size();
    	for(int i = 0; i < size; i++) {
    		if( !announcementService.getAll().get(size -i - 1).getTitle().isEmpty() && !announcementService.getAll().get(size -i - 1).getText().isEmpty() ) {
    			data.add(announcementService.getAll().get(size - i - 1));
    		}
    		
    	}
    	servletRequest.setAttribute("data",data);
    	
    	GradOperations op = gradOperations.getOperations();
    	
    	servletRequest.setAttribute("interview",op.isDateAndLocationAnnouncement());
    	servletRequest.setAttribute("result", op.isResultAnnouncement());
    	
    	return "thymeleaf/news";
    }
    
	
	@GetMapping("announcement/add")
    public String registration(Model model,Announcement announcement) {
        return "thymeleaf/sample2";
    }
	
	@PostMapping("announcement/add")
    public ResponseEntity<String> registration(@ModelAttribute Announcement announcement) {
		announcementService.save(announcement);
        return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);
    }
}
