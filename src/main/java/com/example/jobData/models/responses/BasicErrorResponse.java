package com.example.jobData.models.responses;

import lombok.Data;

@Data
public class BasicErrorResponse {
    private String exception;
    private String message;
    private int status;
    private String error;

    public BasicErrorResponse(String exception, String message, int status, String error) {
        this.exception = exception;
        this.message = message;
        this.status = status;
        this.error = error;
    }
}
