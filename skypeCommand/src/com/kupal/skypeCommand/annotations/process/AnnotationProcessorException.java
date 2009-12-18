package com.kupal.skypeCommand.annotations.process;

/**
 * @author Kupal 3kb
 */
public class AnnotationProcessorException extends Exception {

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
