package com.keva.emp.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Map;

import static com.keva.emp.utils.KevaConstants.Codes.SUCCESS_CODE;
import static com.keva.emp.utils.KevaConstants.ErrorMessages.FAILED;
import static com.keva.emp.utils.KevaConstants.SuccessMessages.SUCCESS;


@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {

    private Integer statusCode;
    private String status;
    private String message;
    private String exceptionMessage;
    private Map<String, Object> errors;
    private T data;

    @Override
    public String toString() {
        return "ResponseModel [statusCode=" + statusCode + ", status=" + status + ", message=" + message
                + ", exceptionMessage=" + exceptionMessage + ", data=" + data + "]";
    }

    public static <T> ApiResponse<T> successResponse(String message, T data) {
        return ApiResponse
                .<T>builder()
                .data(data)
                .message(message)
                .status(SUCCESS)
                .statusCode(SUCCESS_CODE)
                .build();
    }

    public static <T> ApiResponse<T> failedResponse(String message) {
        return ApiResponse
                .<T>builder()
                .message(message)
                .status(FAILED)
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }
}
