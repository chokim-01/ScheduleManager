package com.web.backend.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, length = 50)
    private String email;
    @Column(unique = true, length = 50)
    private String nickname;
    @Column(nullable = false)
    private String encryptedPassword;
    private String profilePicture;

    private LocalDateTime signedAt;
    private boolean isCertificated;
    private String authenticationKey;

    @Builder
    public User(String email, String nickname, String encryptedPassword, String profilePicture) {
        this.email = email;
        this.nickname = nickname;
        this.encryptedPassword = encryptedPassword;
        this.profilePicture = profilePicture;
        this.isCertificated = false;
        changeAuthenticationKey();
    }
    private void changeAuthenticationKey(){
        this.authenticationKey = UUID.randomUUID().toString();
    }
    private void certificateUser(){
        this.isCertificated = true;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
