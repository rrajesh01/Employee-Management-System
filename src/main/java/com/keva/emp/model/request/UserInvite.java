package com.keva.emp.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserInvite {

    @NotBlank(message = "Email is required")
    @Email(message = "Please enter a valid email address")
    private String userName;
}
