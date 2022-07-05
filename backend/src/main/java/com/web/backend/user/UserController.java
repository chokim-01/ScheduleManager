package com.web.backend.user;

import com.web.backend.logger.Trace;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final CreateRequestValidator validator;

    @InitBinder("userCreateRequest")
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(validator);
    }

    @PostMapping("/user")
    @Trace
    public ResponseEntity<String> createUser(@Valid @RequestBody UserCreateRequest request){

        userService.createUser(request);

        String email = request.getEmail();

        return ResponseEntity.ok(email);
    }

    @GetMapping("/user/check-email-auth/{key}")
    public ResponseEntity<String> authorizationUser(String key){
        userService.authorizationUser(key);
        return ResponseEntity.ok().build();
    }




}
