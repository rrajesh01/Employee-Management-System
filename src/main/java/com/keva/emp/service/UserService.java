package com.keva.emp.service;

import com.keva.emp.model.request.UserInvite;
import com.keva.emp.model.response.ApiResponse;
import com.keva.emp.repository.UserRepository;
import com.keva.emp.utils.KevaConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    final private UserRepository userRepository;
    private final JavaMailSender mailSender;

    public ApiResponse<String> inviteEmployee(UserInvite userInvite) {

        if (userRepository.existsByUserName(userInvite.getUserName())) {
            return ApiResponse.failedResponse(KevaConstants.ErrorMessages.USERNAME_ALREADY_EXIT);

        }

        String inviteToken = UUID.randomUUID().toString();

        sendInvitationEmail(
                userInvite.getUserName(),
                inviteToken
        );

        return ApiResponse.successResponse(
                KevaConstants.SuccessMessages.INVITATION_EMAIL_SENT_SUCCESSFULLY,
                null);
    }

    private void sendInvitationEmail(String userName, String token) {

        String inviteLink = "http://localhost:3000/register?token=" + token;

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(userName);
        message.setSubject("Invitation to Join Organization");

        message.setText("Hello " + userName + ",\n\n" +
                "You have been invited to join our organization.\n\n" +
                "Please click the link below to complete your registration:\n" +
                inviteLink +
                "\n\nThis invitation link is valid for 24 hours.\n\n" +
                "Regards,\n" +
                "HR Team"
        );

        mailSender.send(message);
    }
}
