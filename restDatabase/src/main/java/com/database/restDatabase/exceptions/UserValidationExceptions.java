package com.database.restDatabase.exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UserValidationExceptions {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> userValidationErrorsHandler(ConstraintViolationException ex) {
        // Handle validation errors here
        Map<String, String> errorMessages = new HashMap<>();
        Map<String, Object> response=new HashMap<>();

        ex.getConstraintViolations().forEach(conflict -> {
            errorMessages.put(String.valueOf(conflict.getPropertyPath()), conflict.getMessageTemplate());
        });

        response.put("status", "Failed");
        response.put("errors", errorMessages);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


}
