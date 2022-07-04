package com.web.backend.user;

import lombok.Getter;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Getter
public class UserCreateRequest {

    @NotBlank
    @Size(min = 2, max = 20)
    private String email;
    @NotBlank
    @Size(min = 2, max = 20)
    private String nickname;
    @NotBlank
    @Size(min = 2, max = 20)
    private String plainPassword;
    @Nullable
    private String profilePicture;
}
