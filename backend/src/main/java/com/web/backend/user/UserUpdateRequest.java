package com.web.backend.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Size;

@AllArgsConstructor
@Getter
@ToString
public class UserUpdateRequest {

    @Size(min = 2, max = 20)
    private String nickname;

    @Size(min = 2, max = 20)
    private String plainPassword;
}
