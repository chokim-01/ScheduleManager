package com.web.backend.notification.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class SimpleMail {
    private String receiverEmail;
    private String title;
    private String content;
}
