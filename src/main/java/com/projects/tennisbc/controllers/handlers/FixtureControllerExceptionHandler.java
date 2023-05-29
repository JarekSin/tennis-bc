package com.projects.tennisbc.controllers.handlers;

import com.projects.tennisbc.controllers.handlers.dtos.ErrorMessage;
import com.projects.tennisbc.exceptions.FixtureInCompleteException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FixtureControllerExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ErrorMessage fixtureInCompleteExceptionHandler(FixtureInCompleteException exception) {
        return ErrorMessage.ErrorMessageBuilder.anErrorMessage()
                .withErrorCode(exception.getErrorCode())
                .withDescription(exception.getMessage())
                .build();
    }

}
