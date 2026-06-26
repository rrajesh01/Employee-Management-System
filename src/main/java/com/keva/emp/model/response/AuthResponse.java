package com.keva.emp.model.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AuthResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private String jwt;
    private String apiVersion;
    private String message;
    private String status;
    private String activeProfile;
    private long expiredIn;
    private String mobileNumber;
    private String userName;
    private String userType;
    private String email;

    public AuthResponse() {
        super();
    }

    public AuthResponse(String apiVersion) {
        super();
        this.apiVersion = apiVersion;
    }

    public AuthResponse(String apiVersion, String status) {
        super();
        this.apiVersion = apiVersion;
        this.status = status;
    }

    public AuthResponse(String apiVersion, String status, String jwt) {
        super();
        this.apiVersion = apiVersion;
        this.status = status;
        this.jwt = jwt;
    }

    public AuthResponse(String apiVersion, String status, String jwt, String message, String activeProfile) {
        super();
        this.apiVersion = apiVersion;
        this.status = status;
        this.message = message;
        this.jwt = jwt;
        this.activeProfile = activeProfile;
    }

    @Override
    public String toString() {
        return "AuthenticationResponse [jwt=" + jwt + ", apiVersion=" + apiVersion + ", message=" + message
                + ", status=" + status + ", activeProfile=" + activeProfile + "]";
    }

}
