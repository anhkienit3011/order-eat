package com.example.identityservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized error",HttpStatus.INTERNAL_SERVER_ERROR),

    INVALID_KEY(1001,"Invalid message key",HttpStatus.BAD_REQUEST),
    USER_EXISTED(1002,"User existed",HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003,"username must be at least 5 characters",HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1004,"password must be at least 8 characters",HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005,"User existed",HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006,"Unauthenticated",HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007,"Unauthorized",HttpStatus.FORBIDDEN)


    ;

    private int code;
    private String message;
    private HttpStatusCode statusCode;
}
