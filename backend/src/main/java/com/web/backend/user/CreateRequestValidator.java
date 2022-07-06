package com.web.backend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@RequiredArgsConstructor
@Component
public class CreateRequestValidator implements Validator {
    private final UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(UserCreateRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserCreateRequest request = (UserCreateRequest) target;
        if (userRepository.existsByEmail(request.getEmail())){
            throw new IllegalArgumentException("exist email");
        }
        if (userRepository.existsByNickname(request.getNickname())){
            throw new IllegalArgumentException("exist nickname");
        }
        if (userRepository.existsByUserId(request.getUserId())){
            throw new IllegalArgumentException("exist id");
        }


    }
}
