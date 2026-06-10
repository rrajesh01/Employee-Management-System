package com.keva.emp.controller;

import com.keva.emp.model.request.UserInvite;
import com.keva.emp.model.response.ApiResponse;
import com.keva.emp.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    final private UserService userService;

    @PostMapping("/invite")
    public ApiResponse<String> inviteEmployee(@RequestBody @Valid UserInvite userInvite) {

        return userService.inviteEmployee(userInvite);
    }
}
