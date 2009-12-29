package com.kupal.skypeCommand.validator;

/**
 * @author Kupal 3kb
 */
public interface Validator<T> {

    boolean validate(T t) throws AnnotationValidationException;
}
