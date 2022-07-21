//package com.sks.sa.boss.config.mail;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//
///**
// * @author PRADEEP
// *
// */
//
//@Configuration
//public class AppMailConfig {
//	
//	private String fromMail = "sandeep.samantaray2@gmail.com";
//
//	@Autowired
//	private JavaMailSender javaMailSender;
//	
//	public String sendMailMethod(String reciever,String subject, String body) {
//		SimpleMailMessage mailmessage = new SimpleMailMessage();
////		mailmessage.setFrom(fromMail);
//		mailmessage.setTo(reciever);
//		mailmessage.setSubject(subject);
//		mailmessage.setText(body);
//		javaMailSender.send(mailmessage);
//		return "SuccessFully sent";
//	}
//	
//}
