package com.kupal.skypeCommand.exception;

/**
 * @author Kupal 3kb
 */
public class AnnotationValidationException extends ValidationException {

    public AnnotationValidationException() {
        super();
    }

    public AnnotationValidationException(String message) {
        super(message);
    }

    public AnnotationValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnnotationValidationException(Throwable cause) {
        super(cause);
    }
}
