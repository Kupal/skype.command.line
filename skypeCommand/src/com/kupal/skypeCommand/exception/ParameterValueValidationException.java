package com.kupal.skypeCommand.exception;

public class ParameterValueValidationException extends ValidationException {

    public ParameterValueValidationException() {
    }

    public ParameterValueValidationException(String message) {
        super(message);
    }

    public ParameterValueValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterValueValidationException(Throwable cause) {
        super(cause);
    }
}
