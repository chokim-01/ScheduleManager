package com.web.backend.user;

import com.web.backend.logger.Trace;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final CreateRequestValidator validator;

    @InitBinder("userCreateRequest")
    public void initBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(validator);
    }

    @PostMapping("/user")
    @Trace
    public ResponseEntity<String> createUser(@Valid @RequestBody UserCreateRequest request) {

        userService.createUser(request);

        String email = request.getEmail();

        return ResponseEntity.ok(email);
    }

    @GetMapping("/check-email-auth/{key}")
    public ResponseEntity<String> authorizationUser(@PathVariable String key) {
        userService.authorizationUser(key);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/user/{id}/picture")
    public ResponseEntity<String> changeUserProfilePicture(@RequestBody MultipartFile file, @PathVariable Long id, @CurrentUser User user) {
        if (!user.getId().equals(id)) {
            throw new RuntimeException("");
        }
        userService.changeUserProfilePicture(file, id);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("/user/{id}/info")
    @Trace
    public ResponseEntity<String> changeUserInfo(@RequestBody UserUpdateRequest request, @PathVariable Long id, @CurrentUser User user) {
        if (!user.getId().equals(id)) {
            throw new RuntimeException("");
        }
        userService.changeUserInfo(request, id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id, @CurrentUser User user) {
        if (!user.getId().equals(id)) {
            throw new RuntimeException("");
        }
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<UserDto> showUserInfo(@PathVariable Long id){
        UserDto userDto = userService.showUserInfo(id);
        return ResponseEntity.ok().body(userDto);
    }


}
