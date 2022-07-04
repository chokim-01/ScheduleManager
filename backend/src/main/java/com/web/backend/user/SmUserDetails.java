package com.web.backend.user;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Collections;

@Getter
public class SmUserDetails extends User {
    private final com.web.backend.user.User user;


    public SmUserDetails(com.web.backend.user.User user) {
        super(user.getEmail(), user.getEncryptedPassword(), Collections.emptyList());
        this.user = user;
    }
}
