package com.keva.emp.model.request;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class LoginRequest {

    @Email
    private String userName;
    private String password;
}
