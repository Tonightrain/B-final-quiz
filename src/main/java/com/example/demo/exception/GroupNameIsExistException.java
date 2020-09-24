package com.example.demo.exception;

import static com.example.demo.component.ErrorMessage.GROUP_NAME_REPEAT;

public class GroupNameIsExistException extends RuntimeException {
    public GroupNameIsExistException() {
        super(GROUP_NAME_REPEAT);
    }
}
