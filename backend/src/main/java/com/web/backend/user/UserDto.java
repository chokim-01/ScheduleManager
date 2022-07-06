package com.web.backend.user;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;


@ToString
@Getter
public class UserDto {
    private Long id;
    private String userId;
    private String email;
    private String nickname;
    private String profilePicture;
    private LocalDateTime signedAt;
    @Builder
    public UserDto(Long id, String userId, String email, String nickname, String profilePicture, LocalDateTime signedAt) {
        this.id = id;
        this.userId = userId;
        this.email = email;
        this.nickname = nickname;
        this.profilePicture = profilePicture;
        this.signedAt = signedAt;
    }
}
