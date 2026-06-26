package com.keva.emp.service;

import com.keva.emp.Enum.Status;
import com.keva.emp.Exception.TimesheetException;
import com.keva.emp.entity.Users;
import com.keva.emp.model.request.LoginRequest;
import com.keva.emp.model.response.AuthResponse;
import com.keva.emp.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.keva.emp.utils.KevaConstants.Codes.RESP_CODE_USER_NOT_FOUND;
import static com.keva.emp.utils.KevaConstants.ErrorMessages.*;
import static com.keva.emp.utils.KevaConstants.SuccessMessages.RESP_MESSAGE_SIGNIN_SUCCESSFULLY;
import static com.keva.emp.utils.KevaConstants.SuccessMessages.SUCCESS;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse loginWithEmailAndPassword(@Valid LoginRequest loginRequest) {
        AuthResponse response = new AuthResponse();
        try {
            Optional<Users> userDetails = userRepository.findByUserNameAndStatus(loginRequest.getUserName(), Status.ACTIVE.getId());

            if (userDetails.isPresent()) {
                Users user = userDetails.get();
                if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                    throw new TimesheetException(RESP_CODE_USER_NOT_FOUND, FAILED,
                            INVALID_USERNAME_PASSWORD);
                }
                final String jwt = jwtService.generateToken(user);
                response.setApiVersion("1");
                response.setJwt(jwt);
                response.setMessage(RESP_MESSAGE_SIGNIN_SUCCESSFULLY);
                response.setStatus(SUCCESS);
                //response.setExpiredIn(TimeUnit.MINUTES.toMillis(applicationJwtTokenValidityMinutes));
                response.setEmail(user.getUserName());
                //response.setUserName(user.getFirstName() + " " + user.getLastName());

                return response;
            }

            // Else case
            throw new TimesheetException(RESP_CODE_USER_NOT_FOUND, FAILED,
                    RESP_MESSAGE_USER_NOT_FOUND);

        } catch (TimesheetException e) {
            throw e;
        } catch (Exception e) {
            throw new TimesheetException(RESP_CODE_USER_NOT_FOUND, FAILED,
                    RESP_MESSAGE_USER_NOT_FOUND);
        }
    }
}
