package com.web.backend.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.MailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    MailSender mailSender;
    @Mock
    UserRepository userRepository;
    @Spy
    BCryptPasswordEncoder passwordEncoder;
    @Spy
    ProfilePictureService pictureUploadService;
    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("loadUserByUsername - id 존재할 때 테스트")
    void loadUserByUsername() {
        User user = User.builder().userId("jaegon")
                .email("jagon@gmail.com")
                .encryptedPassword(passwordEncoder.encode("1234"))
                .nickname("jaegon").build();
        when(userRepository.findByUserId("jaegon")).thenReturn(Optional.ofNullable(user));

        SmUserDetails userDetails = (SmUserDetails) userService.loadUserByUsername("jaegon");

        assertThat(user).isEqualTo(userDetails.getUser());
    }
    @Test
    @DisplayName("loadUserByUsername - id 존재하지 않을 때 에러 테스트")
    void loadUserByUsernameFailure() {

        when(userRepository.findByUserId("jaegon")).thenReturn(Optional.empty());



        String message = assertThrows(IllegalArgumentException.class, () -> userService.loadUserByUsername("jaegon")).getMessage();
        assertThat(message).isEqualTo("user not exist");
    }

    @Test
    @DisplayName("회원 가입 성공 테스트")
    void createUser() {
        UserCreateRequest request = new UserCreateRequest("jaegon", "jaegon@gmail.com", "1234", "jaegon");
        when(userRepository.save(any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        User user = userService.createUser(request);

        assertThat(request.getUserId()).isEqualTo(user.getUserId());
        assertThat(request.getEmail()).isEqualTo(user.getEmail());
        assertTrue(passwordEncoder.matches(request.getPlainPassword(), user.getEncryptedPassword()));
        assertThat(request.getNickname()).isEqualTo(user.getNickname());
    }


}