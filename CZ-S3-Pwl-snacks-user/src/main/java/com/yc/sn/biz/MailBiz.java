package com.yc.sn.biz;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailBiz {
	
	@Resource
	private JavaMailSender mailSender;//Springboot 提供的邮件发送器对象
	@Value("${mail.from.addr}")//读取配置参数
	private String from;
	
	/**
	 * subject 邮件标题
	 * */
	public void sendSimpleMail(String to,String subject,String content) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(content);
		mailSender.send(message);
	}
}
