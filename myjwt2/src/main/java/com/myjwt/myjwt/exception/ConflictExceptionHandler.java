package com.myjwt.myjwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConflictExceptionHandler {

    @ExceptionHandler(value = {JwtUserConflictException.class})
    public ResponseEntity<Object> handleConflictException(JwtUserConflictException jwtUserConflictException) {
        JwtUserException jwtUserException =new JwtUserException(
             jwtUserConflictException.getMessage(),
             jwtUserConflictException.getCause(),
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(jwtUserException, HttpStatus.CONFLICT);
    }
}
