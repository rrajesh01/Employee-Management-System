package com.keva.emp.service;

import com.keva.emp.entity.Users;
import com.keva.emp.model.request.UserInvite;
import com.keva.emp.model.response.ApiResponse;
import com.keva.emp.repository.UserRepository;
import com.keva.emp.utils.KevaConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    final private UserRepository userRepository;
    private final JavaMailSender mailSender;
    private final PasswordEncoder passwordEncoder;

    public ApiResponse<String> inviteEmployee(UserInvite userInvite) {

        if (userRepository.existsByUserName(userInvite.getUserName())) {
            return ApiResponse.failedResponse(
                    KevaConstants.ErrorMessages.USERNAME_ALREADY_EXIT);
        }

        String randomPassword = generateRandomPassword();

        Users user = new Users();
        user.setUserName(userInvite.getUserName());
        user.setPassword(passwordEncoder.encode(randomPassword));
        user.setStatus(1);

        userRepository.save(user);

        sendInvitationEmail(
                userInvite.getUserName(),
                randomPassword
        );

        return ApiResponse.successResponse(
                KevaConstants.SuccessMessages.INVITATION_EMAIL_SENT_SUCCESSFULLY,
                null);
    }

    private void sendInvitationEmail(String userName, String password) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(userName);
        message.setSubject("Welcome to Organization");

        message.setText(
                "Hello,\n\n" +
                        "Your account has been created successfully.\n\n" +
                        "Username: " + userName + "\n" +
                        "Temporary Password: " + password + "\n\n" +
                        "Please login and change your password immediately.\n\n" +
                        "Regards,\nHR Team"
        );

        mailSender.send(message);
    }

    private String generateRandomPassword(){
        return UUID.randomUUID()
                .toString()
                .replace("-", "")
                .substring(0, 10);
    }
}
