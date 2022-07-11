package com.web.backend.notification.mail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {
    private final MailSender mailSender;

    public void send(SimpleMail mail){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getReceiverEmail());
        mailMessage.setSubject(mail.getTitle());
        mailMessage.setText(mail.getContent());

        log.info("mail:{}",mailMessage);
    }



}
