package com.te.sendEmail.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.sendEmail.EmailSender;
import com.te.sendEmail.dto.EmailDto;

@RestController
@RequestMapping(path = "/email")
public class EmailController {
	
	@Autowired
	private EmailSender emailSender;
	
	@PostMapping(path = "/send")
	public String sendMail(@RequestBody EmailDto dto) throws MessagingException {
		String message = emailSender.sendEmailWithAttachment(dto.getTo(),dto.getSubject(),dto.getBody(),dto.getAttachment());
		return message;
	}

}
