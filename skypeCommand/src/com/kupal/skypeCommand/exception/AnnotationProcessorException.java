package com.kupal.skypeCommand.exception;

/**
 * @author Kupal 3kb
 */
public class AnnotationProcessorException extends CommandException {

    public AnnotationProcessorException() {
        super();
    }

    public AnnotationProcessorException(String message) {
        super(message);
    }

    public AnnotationProcessorException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnnotationProcessorException(Throwable cause) {
        super(cause);
    }
}
