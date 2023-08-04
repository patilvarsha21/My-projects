package com.te.sendEmail;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {
	@Autowired
	private JavaMailSender javaMailSender;
	
	public String sendEmailWithAttachment(String to, String subject, String body, String attachment) throws MessagingException {
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper messageHelper=new MimeMessageHelper(mimeMessage, true);
		messageHelper.setTo(to);;
		messageHelper.setSubject(subject);
		messageHelper.setText(body);
		FileSystemResource fileSystemResource=new FileSystemResource(new File(attachment));
		messageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
		javaMailSender.send(mimeMessage);
		return "email sent successfully";
		
	}

}
