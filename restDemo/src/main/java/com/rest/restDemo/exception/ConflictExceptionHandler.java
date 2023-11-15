package com.rest.restDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConflictExceptionHandler {

    @ExceptionHandler(value = {CloudVendorConflictException.class})
    public ResponseEntity<Object> handleConflictException(CloudVendorConflictException cloudVendorConflictException) {
        CloudVendorException cloudVendorException=new CloudVendorException(
             cloudVendorConflictException.getMessage(),
             cloudVendorConflictException.getCause(),
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(cloudVendorException, HttpStatus.CONFLICT);
    }
}
