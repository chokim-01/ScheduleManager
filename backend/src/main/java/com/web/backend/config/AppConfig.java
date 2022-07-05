package com.web.backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class AppConfig {
    public MailSender mailSender(){
        return new JavaMailSenderImpl();
    }
}
