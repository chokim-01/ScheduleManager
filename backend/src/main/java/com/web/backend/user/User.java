package com.web.backend.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 50)
    private String userId;
    @Column(unique = true, length = 50)
    private String email;
    @Column(unique = true, length = 50)
    private String nickname;
    @Column(nullable = false)
    private String encryptedPassword;
    private String profilePicture;

    @CreatedDate
    private LocalDateTime signedAt;
    private boolean isCertificated;
    private String authenticationKey;

    @Builder
    public User(String userId, String email, String nickname, String encryptedPassword) {
        this.userId = userId;
        this.email = email;
        this.nickname = nickname;
        this.encryptedPassword = encryptedPassword;
        changeAuthenticationKey();
        this.signedAt = LocalDateTime.now();
    }




    private void changeAuthenticationKey(){
        this.authenticationKey = UUID.randomUUID().toString();
    }

    protected void authorization(){
        this.isCertificated = true;
        this.authenticationKey = null;
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

    public UserDto toDto(){
        return UserDto.builder()
                .id(id)
                .email(email)
                .userId(userId)
                .nickname(nickname)
                .profilePicture(profilePicture)
                .signedAt(signedAt)
                .build();
    }
}
