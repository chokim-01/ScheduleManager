package com.web.backend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final MailSender mailSender;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new IllegalArgumentException("user not exist"));
        return new SmUserDetails(user);
    }


    public Long createUser(@Valid UserCreateRequest request){
        User user = User.builder()
                .userId(request.getUserId())
                .email(request.getEmail())
                .nickname(request.getNickname())
                .encryptedPassword(passwordEncoder.encode(request.getPlainPassword())).build();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("회원 가입 인증");
        message.setText("/user/check-email-auth/"+ user.getAuthenticationKey());

//        mailSender.send(message);

        return userRepository.save(user).getId();
    }


    public void authorizationUser(String key) {
        User user = userRepository.findByAuthenticationKey(key).orElseThrow(() -> new IllegalArgumentException("invalid key"));
        user.authorization();
    }
}
