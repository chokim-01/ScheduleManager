package com.web.backend.notification.handler;

import com.web.backend.logger.Trace;
import com.web.backend.notification.event.UserCreatedEvent;
import com.web.backend.notification.mail.MailService;
import com.web.backend.notification.mail.SimpleMail;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class UserCreatedEventHandler {
    private final MailService mailService;

    @TransactionalEventListener
    @Trace
    @Async
    public void signup(UserCreatedEvent event){
        SimpleMail mailForm = createMailForm(event);
        mailService.send(mailForm);
    }

    SimpleMail createMailForm(UserCreatedEvent event){
        return new SimpleMail(event.getUser().getEmail(),"인증 메일입니다",event.getUser().getAuthenticationKey());
    }
}
