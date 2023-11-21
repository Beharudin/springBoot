package com.myjwt.myjwt.exception;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
public class JwtUserException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;

}
