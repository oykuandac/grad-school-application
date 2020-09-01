package com.gradschool.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gradschool.model.Interview;
import com.gradschool.service.GradOperationsServiceImpl;
import com.gradschool.service.InterviewService;

@Controller
public class InterviewController {
	
	
    @Autowired
    private InterviewService interviewService;
    
    @Autowired
    private HttpServletRequest httpRequest;
    
    @Autowired
    private GradOperationsServiceImpl gradOperationsService;
	
	@GetMapping("/interview")
	public String interview(Model model) {
	
		model.addAttribute(model);
		
		return("jsp/interview");
	}

	@PostMapping("/interview/update")
	public ResponseEntity<String> interview(@RequestParam long id, @ModelAttribute Interview interview) {
		interviewService.updateInterview(id, interview);
        return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);		
	}
	
	@PostMapping("/interview/save")
	public ResponseEntity<String> addInterview(@ModelAttribute Interview interview) {
		interviewService.save(interview);
        return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);		
	}
	
	@GetMapping("/findOne")
	@ResponseBody
	public Interview findOne(long id) {
		return interviewService.findOne(id);
	}
		
	@GetMapping("interviewNote/{interviewId}/{note}")
    public ResponseEntity<String> updateNote(@PathVariable long interviewId,  @PathVariable double note) {
		interviewService.setNote(interviewId, note);
        return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);
    }
	
	@PostMapping("/interviewDateAndLocation/announce")
	public ResponseEntity<String> announceDateAndLocations() {
		System.out.println("A");
		this.gradOperationsService.announceDateAndLocations();
        return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping("/interviewDateAndLocation")
	public String announceDateAndLoc() {
		if(gradOperationsService.getOperations().isDateAndLocationAnnouncement() == false) {
			return "noooooo0000000000000!11111!1";
		}
		httpRequest.setAttribute("data", this.interviewService.getAll());
		return("thymeleaf/interviewAnnounce");
	}

}

