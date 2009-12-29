package com.kupal.skypeCommand.validator.annotation.impl;

import com.kupal.skypeCommand.annotations.AnnotationUtil;
import com.kupal.skypeCommand.annotations.Response;
import com.kupal.skypeCommand.validator.AnnotationValidationException;
import com.kupal.skypeCommand.validator.annotation.AnnotationValidator;
import com.kupal.skypeCommand.response.CommandResponse;

/**
 * @author Kupal 3kb
 */
public class ResponseValidator implements AnnotationValidator<Class<CommandResponse>> {

    public boolean validate(Class<CommandResponse> commandResponseClass) throws AnnotationValidationException {
        boolean isResponse = AnnotationUtil.getAnnotation(Response.class, commandResponseClass, true) != null;

        if(!isResponse)
            throw new AnnotationValidationException(commandResponseClass.getName() + " should be annotated by " + Response.class.getName());

        return true;
    }
}
