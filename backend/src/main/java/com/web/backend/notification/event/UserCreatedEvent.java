package com.web.backend.notification.event;

import com.web.backend.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserCreatedEvent {
    private final User user;
}
