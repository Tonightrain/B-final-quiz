package com.example.demo.exception;

import static com.example.demo.component.ErrorMessage.TRAINER_NOT_FOUND;

public class TrainerIsNotExistException extends RuntimeException {
    public TrainerIsNotExistException() {
        super(TRAINER_NOT_FOUND);
    }
}
