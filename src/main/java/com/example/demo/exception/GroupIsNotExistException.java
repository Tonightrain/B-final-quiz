package com.example.demo.exception;

import static com.example.demo.component.ErrorMessage.GROUP_NOT_FOUND;

public class GroupIsNotExistException extends RuntimeException{
    public GroupIsNotExistException(){
        super(GROUP_NOT_FOUND);
    }
}
