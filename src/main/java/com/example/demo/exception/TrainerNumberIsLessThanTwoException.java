package com.example.demo.exception;

import static com.example.demo.component.ErrorMessage.TRAINER_NUMBER_LESS;

public class TrainerNumberIsLessThanTwoException extends RuntimeException {
    public TrainerNumberIsLessThanTwoException(){
        super(TRAINER_NUMBER_LESS);
    }
}
