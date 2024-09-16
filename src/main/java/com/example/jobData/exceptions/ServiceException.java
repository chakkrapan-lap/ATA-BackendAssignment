package com.example.jobData.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ServiceException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String message;

    public ServiceException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
