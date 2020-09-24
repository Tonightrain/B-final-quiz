package com.example.demo.api;

import com.example.demo.exception.ErrorResult;
import com.example.demo.exception.TraineeIsNotExistException;
import com.example.demo.exception.TrainerIsNotExistException;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

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

    @ExceptionHandler(TraineeIsNotExistException.class)
    public ResponseEntity<ErrorResult> handleTrainee(TraineeIsNotExistException ex){
        ErrorResult errorResult = ErrorResult.builder()
                .message(ex.getMessage())
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .status(Response.SC_NOT_FOUND)
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }

    @ExceptionHandler(TrainerIsNotExistException.class)
    public ResponseEntity<ErrorResult> handleTrainer(TrainerIsNotExistException ex){
        ErrorResult errorResult = ErrorResult.builder()
                .message(ex.getMessage())
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .status(Response.SC_NOT_FOUND)
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResult);
    }


}
