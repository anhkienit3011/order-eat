package com.example.identityservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized error"),

    INVALID_KEY(1001,"Invalid message key"),
    USER_EXISTED(1002,"User existed"),
    USERNAME_INVALID(1003,"username must be at least 5 characters"),
    PASSWORD_INVALID(1004,"password must be at least 8 characters"),
    USER_NOT_EXISTED(1005,"User existed"),
    UNAUTHENTICATED(1006,"Unauthenticated")

    ;

    private int code;
    private String message;
}
