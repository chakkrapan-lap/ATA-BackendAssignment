package com.example.jobData.exceptions;

import com.example.jobData.models.responses.BasicErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<BasicErrorResponse> handleServiceException(ServiceException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(
                new BasicErrorResponse(
                        ex.getClass().getSimpleName(),
                        ex.getMessage(),
                        ex.getHttpStatus().value(),
                        ex.getHttpStatus().getReasonPhrase()
                )
        );
    }
}
