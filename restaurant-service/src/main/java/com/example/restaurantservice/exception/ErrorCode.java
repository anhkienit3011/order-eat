package com.example.restaurantservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
// identity
    INVALID_KEY(1001, "Invalid message key", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1002, "User existed", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003, "username must be at least {min} characters", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1004, "password must be at least {min} characters", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "User existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "Unauthorized", HttpStatus.FORBIDDEN),
    INVALID_DOB(1008, "Your age be at least {min}", HttpStatus.BAD_REQUEST),


    //restaurant
    RESTAURANT_NOT_FOUND(1009, "Restaurant not existed", HttpStatus.NOT_FOUND);

    private int code;
    private String message;
    private HttpStatusCode statusCode;
}
