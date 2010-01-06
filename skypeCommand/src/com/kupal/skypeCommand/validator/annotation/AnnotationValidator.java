package com.kupal.skypeCommand.validator.annotation;

import com.kupal.skypeCommand.exception.AnnotationValidationException;
import com.kupal.skypeCommand.validator.Validator;

/**
 * @author Kupal 3kb
 */
public interface AnnotationValidator<T> extends Validator<T> {

    void validate(T t) throws AnnotationValidationException;
}
