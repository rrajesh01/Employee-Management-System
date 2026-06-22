package com.keva.emp.controller;

import com.keva.emp.model.request.UserInvite;
import com.keva.emp.model.response.ApiResponse;
import com.keva.emp.service.UserService;
import com.keva.emp.utils.KevaConstants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    final private UserService userService;

    @PostMapping("/invite")
    public ApiResponse<String> inviteEmployee(@RequestBody @Valid UserInvite userInvite) {

        return userService.inviteEmployee(userInvite);
    }

    @GetMapping
    public ApiResponse<String> greetingMessage(){
        return ApiResponse.successResponse(
                KevaConstants.SuccessMessages.INVITATION_EMAIL_SENT_SUCCESSFULLY,
                null);
    }
}
