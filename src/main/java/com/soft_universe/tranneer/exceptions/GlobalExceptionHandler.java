package com.soft_universe.tranneer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AlienNotFoundException.class)
    public ResponseEntity <ErrorResponceDTO> handleAlienNotFound(AlienNotFoundException ex){
        ErrorResponceDTO error=new ErrorResponceDTO(
                ex.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

}
