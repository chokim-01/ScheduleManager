package com.web.backend.notification.sse;

import com.web.backend.user.User;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    @ManyToOne
    private User user;

    private String url;

    public Notification(String content, User user, String url) {
        this.content = content;
        this.user = user;
        this.url = url;
    }
    public NotificationDto toDto(){
        return new NotificationDto(content,url);
    }

}
