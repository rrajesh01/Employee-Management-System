package com.keva.emp.Exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@Getter
@Setter
public class TimesheetException extends ResponseStatusException {

    private final int code;
    private final String statusStirng;
    private final Date timestamp;
    private final String message;
    private final String details = "";

    public TimesheetException(int code, String status, String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, status + "(" + code + "): " + message);
        this.timestamp = new Date();
        this.code = code;
        this.statusStirng = status;
        this.message = message;
    }
}
