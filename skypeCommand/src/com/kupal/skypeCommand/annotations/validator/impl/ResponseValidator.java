package com.kupal.skypeCommand.annotations.validator.impl;

import com.kupal.skypeCommand.annotations.AnnotationUtil;
import com.kupal.skypeCommand.annotations.Response;
import com.kupal.skypeCommand.annotations.validator.AnnotationValidationException;
import com.kupal.skypeCommand.annotations.validator.Validator;
import com.kupal.skypeCommand.response.CommandResponse;

/**
 * @author Kupal 3kb
 */
public class ResponseValidator implements Validator<Class<CommandResponse>> {

    public boolean validate(Class<CommandResponse> commandResponseClass) throws AnnotationValidationException {
        boolean isResponse = AnnotationUtil.getAnnotation(Response.class, commandResponseClass, true) != null;

        if(!isResponse)
            throw new AnnotationValidationException(commandResponseClass.getName() + " should be annotated by " + Response.class.getName());

        return true;
    }
}
