package com.web.backend.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@ToString
@AllArgsConstructor
public class UserCreateRequest {

    @NotBlank
    @Size(min = 2, max = 20)
    private String userId;
    @NotBlank
    @Size(min = 2, max = 20)
    private String email;
    @NotBlank
    @Size(min = 2, max = 20)
    private String plainPassword;
    @NotBlank
    @Size(min = 2, max = 20)
    private String nickname;

}
