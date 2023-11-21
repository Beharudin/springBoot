package com.myjwt.myjwt.exception;

public class JwtUserNotFoundException extends RuntimeException {

    public JwtUserNotFoundException(String message) {
        super(message);
    }

    public JwtUserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
