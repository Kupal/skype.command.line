package com.kupal.skypeCommand.validator.annotation.impl;

import com.kupal.skypeCommand.annotations.CmdParam;
import com.kupal.skypeCommand.annotations.Transient;
import com.kupal.skypeCommand.exception.AnnotationValidationException;
import com.kupal.skypeCommand.validator.annotation.AnnotationValidator;

import java.lang.reflect.Field;

/**
 * @author Kupal 3kb
 */
public class ParameterValidator implements AnnotationValidator<Field> {
    
    public void validate(Field field) throws AnnotationValidationException {

        boolean isTransient = field.isAnnotationPresent(Transient.class);

        if(isTransient)
            return;

        boolean isCommandParameter = field.isAnnotationPresent(CmdParam.class);

        if(!isCommandParameter)
            throw new AnnotationValidationException(field.getName() + " should be annotated by " + CmdParam.class.getName() + " or " + Transient.class.getName());
    }
}
