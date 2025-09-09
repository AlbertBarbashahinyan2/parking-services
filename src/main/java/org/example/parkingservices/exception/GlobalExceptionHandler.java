package org.example.parkingservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException e) {
        final ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .withMessage(e.getMessage())
                .withStatus(HttpStatus.NOT_FOUND)
                .build();

        return ResponseEntity
                .status(exceptionResponse.getStatus())
                .body(exceptionResponse);
    }

    @ExceptionHandler(ResourceAlreadyUsedException.class)
    public ResponseEntity<ExceptionResponse> handleResourceAlreadyUsedException(ResourceAlreadyUsedException e) {
        final ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .withMessage(e.getMessage())
                .withStatus(HttpStatus.CONFLICT)
                .build();
        return ResponseEntity.status(exceptionResponse.getStatus()).body(exceptionResponse);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        final ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .withMessage(e.getMessage())
                .withStatus(HttpStatus.BAD_REQUEST)
                .build();
        return ResponseEntity.status(exceptionResponse.getStatus()).body(exceptionResponse);
    }

}

