package com.rest.restDemo.exception;

public class CloudVendorConflictException extends RuntimeException{

    public CloudVendorConflictException(String message) {
        super(message);
    }

    public CloudVendorConflictException(String message, Throwable cause) {
        super(message, cause);
    }
}
