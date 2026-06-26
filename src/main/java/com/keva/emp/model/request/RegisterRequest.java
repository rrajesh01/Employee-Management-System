package com.keva.emp.model.request;

import lombok.Data;

@Data
public class RegisterRequest {

    private String employeeCode;
    private String employeeName;
    private String email;
    private String mobileNumber;
    private String designation;
    private String department;
    private Double salary;

    private String password;
    private String confirmPassword;
}