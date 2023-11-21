package com.myjwt.myjwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler(value = {JwtUserNotFoundException.class})
    public ResponseEntity<Object> handleCloudVendorNotFoundException
            (JwtUserNotFoundException jwtUserNotFoundException)
    {
        JwtUserException jwtUserException = new JwtUserException(
                jwtUserNotFoundException.getMessage(),
                jwtUserNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(jwtUserException, HttpStatus.NOT_FOUND);
    }
}
