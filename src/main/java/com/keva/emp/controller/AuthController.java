package com.keva.emp.controller;

import com.keva.emp.model.request.LoginRequest;
import com.keva.emp.model.request.RegisterRequest;
import com.keva.emp.model.response.ApiResponse;
import com.keva.emp.model.response.AuthResponse;
import com.keva.emp.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.keva.emp.utils.KevaConstants.Codes.SUCCESS_CODE;
import static com.keva.emp.utils.KevaConstants.SuccessMessages.RESP_MESSAGE_SIGNIN_SUCCESSFULLY;
import static com.keva.emp.utils.KevaConstants.SuccessMessages.SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ApiResponse<AuthResponse> loginWithEmailAndPassword(@Valid @RequestBody LoginRequest loginRequest) {

        return ApiResponse.<AuthResponse>builder()
                .data(authService.loginWithEmailAndPassword(loginRequest))
                .message(RESP_MESSAGE_SIGNIN_SUCCESSFULLY)
                .statusCode(SUCCESS_CODE)
                .status(SUCCESS)
                .build();
    }
}
