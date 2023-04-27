package com.asvladimirov.syntsc.exception;

import com.asvladimirov.syntsc.web.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@ControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleUnexpectedException(RuntimeException exception) {
        log.error("Unexpected exception: {}", exception.getMessage());
        var body = new ErrorResponse("Internal Server Error");
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(body);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleIncorrectSentenceException(IncorrectSentenceException exception) {
        log.error("IncorrectSentenceException exception: {}", exception.getMessage());
        var body = new ErrorResponse(exception.getMessage());
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(body);
    }
}
