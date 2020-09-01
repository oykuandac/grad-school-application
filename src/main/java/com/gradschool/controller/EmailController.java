package com.gradschool.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gradschool.component.SmtpMailSender;
import com.gradschool.model.User;
import com.gradschool.service.UserServiceImpl;

@RestController
public class EmailController {

	@Autowired
	private UserServiceImpl userService;
	
	@Autowired
	private SmtpMailSender smtpMailSender;

	@RequestMapping("/send-mail")
	public void sendMail() throws MessagingException {
		
		smtpMailSender.send("ekremozturk1997@gmail.com", "Test mail from Spring", "Howdy");	
	}
	
	@RequestMapping("/sendMail")
	public ResponseEntity<String> send_Mail(@RequestParam String email,@RequestParam String title,@RequestParam String text) throws MessagingException {
		smtpMailSender.send(email, title, text);
        return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);

	}
	
	@PostMapping("/sendNewPassword")
	public ResponseEntity<String> sendNewPassw(@RequestParam String email) throws MessagingException {
		
		System.out.println("aaaaaaaf");		
		String title = "New Password";
		
		String password = "123456";
	
		User user = userService.findByUsername(email);
		if(user != null) {
			user.setPassword(password);
			userService.updatePassword(user);
			
			smtpMailSender.send(email, title, password);
		}
        return new ResponseEntity<String>("OK!!!",HttpStatus.NO_CONTENT);

	}
	
}
