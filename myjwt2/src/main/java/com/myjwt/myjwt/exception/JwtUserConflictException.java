package com.myjwt.myjwt.exception;

public class JwtUserConflictException extends RuntimeException{

    public JwtUserConflictException(String message) {
        super(message);
    }

    public JwtUserConflictException(String message, Throwable cause) {
        super(message, cause);
    }
}
