package com.kupal.skypeCommand.validator;

/**
 * @author Kupal 3kb
 */
public class AnnotationValidationException extends Exception {

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
