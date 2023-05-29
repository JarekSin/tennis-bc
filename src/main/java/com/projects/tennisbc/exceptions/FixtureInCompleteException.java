package com.projects.tennisbc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FixtureInCompleteException extends RuntimeException{

    private String errorCode;


    public FixtureInCompleteException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;

    }

    public String getErrorCode() {
        return errorCode;
    }

}
