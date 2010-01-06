package com.kupal.skypeCommand.validator.value;

import com.kupal.skypeCommand.exception.ParameterValueValidationException;
import com.kupal.skypeCommand.validator.Validator;

/**
 * @author Kupal 3kb
 */
public interface ParameterValueValidator extends Validator<String> {

    void validate(String value) throws ParameterValueValidationException;
}
