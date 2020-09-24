package com.example.demo.exception;

import static com.example.demo.component.ErrorMessage.TRAINEE_NOT_FOUND;

public class TraineeIsNotExistException extends RuntimeException {
    public TraineeIsNotExistException() {
        super(TRAINEE_NOT_FOUND);
    }
}
