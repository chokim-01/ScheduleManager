package com.web.backend.user;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements UserDetailsService {
    private final MailSender mailSender;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ProfilePictureService pictureService;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new IllegalArgumentException("user not exist"));
        return new SmUserDetails(user);
    }


    public User createUser(@Valid UserCreateRequest request){
        User user = User.builder()
                .userId(request.getUserId())
                .email(request.getEmail())
                .nickname(request.getNickname())
                .encryptedPassword(passwordEncoder.encode(request.getPlainPassword())).build();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("회원 가입 인증");
        message.setText("/user/check-email-auth/"+ user.getAuthenticationKey());

//        mailSender.send(message);

        return userRepository.save(user);
    }


    @Transactional
    public void authorizationUser(String key) {
        User user = userRepository.findByAuthenticationKey(key).orElseThrow(() -> new IllegalArgumentException("invalid key"));
        user.authorization();
    }

    @Transactional
    public void changeUserProfilePicture(MultipartFile file, Long id) {
        User user = userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("user not exist"));
        String beforeProfilePicture = user.getProfilePicture();
        if(beforeProfilePicture!=null){
            pictureService.deleteFile(beforeProfilePicture);
        }

        String fileName = pictureService.fileUploadAndReturnFileName(file);

        user.setProfilePicture(fileName);

    }
    @Transactional
    public void changeUserInfo(UserUpdateRequest request, Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("not exist user"));
        if (request.getNickname()!=null){
            user.setNickname(request.getNickname());
        }
        if (request.getPlainPassword()!=null){
            user.setEncryptedPassword(passwordEncoder.encode(request.getPlainPassword()));
        }

    }
}
