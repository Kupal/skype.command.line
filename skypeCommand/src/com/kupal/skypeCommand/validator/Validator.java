package com.kupal.skypeCommand.validator;

import com.kupal.skypeCommand.exception.ValidationException;

/**
 * @author Kupal 3kb
 */
public interface Validator<T> {

    void validate(T t) throws ValidationException;
}
