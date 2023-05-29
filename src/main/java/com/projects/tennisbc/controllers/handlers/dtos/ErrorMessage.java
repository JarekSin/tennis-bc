package com.projects.tennisbc.controllers.handlers.dtos;

import org.springframework.http.HttpStatus;

public class ErrorMessage {

    private String ErrorCode;
    private String Description;


    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String errorCode) {
        ErrorCode = errorCode;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public static final class ErrorMessageBuilder {
        private String ErrorCode;
        private String Description;

        private ErrorMessageBuilder() {
        }

        public static ErrorMessageBuilder anErrorMessage() {
            return new ErrorMessageBuilder();
        }

        public ErrorMessageBuilder withErrorCode(String ErrorCode) {
            this.ErrorCode = ErrorCode;
            return this;
        }

        public ErrorMessageBuilder withDescription(String Description) {
            this.Description = Description;
            return this;
        }
        public ErrorMessage build() {
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setErrorCode(ErrorCode);
            errorMessage.setDescription(Description);
            return errorMessage;
        }
    }
}
