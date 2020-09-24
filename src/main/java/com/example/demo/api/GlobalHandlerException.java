package com.example.demo.api;

import com.example.demo.exception.ErrorResult;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResult> handleException(MethodArgumentNotValidException ex){
        String message = ex.getBindingResult().getFieldError().getDefaultMessage();
        ErrorResult errorResult = ErrorResult.builder()
                .message(message)
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .status(Response.SC_BAD_REQUEST)
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }


}
