package com.gradschool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl {
	
	@Autowired
	 private JavaMailSender javaMailSender;


	    public void sendMail(String toEmail, String subject, String message) {

	        SimpleMailMessage mailMessage = new SimpleMailMessage();

	        mailMessage.setTo(toEmail);
	        mailMessage.setFrom("gradd.sschool@gmail.com");
	        mailMessage.setSubject(subject);
	        mailMessage.setText(message);


	        javaMailSender.send(mailMessage);
	    }

}
