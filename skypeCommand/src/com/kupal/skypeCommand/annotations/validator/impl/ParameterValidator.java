package com.kupal.skypeCommand.annotations.validator.impl;

import com.kupal.skypeCommand.annotations.CmdParam;
import com.kupal.skypeCommand.annotations.Transient;
import com.kupal.skypeCommand.annotations.validator.AnnotationValidationException;
import com.kupal.skypeCommand.annotations.validator.Validator;

import java.lang.reflect.Field;

/**
 * @author Kupal 3kb
 */
public class ParameterValidator implements Validator<Field> {
    
    public boolean validate(Field field) throws AnnotationValidationException {

        boolean isTransient = field.isAnnotationPresent(Transient.class);

        if(isTransient)
            return true;

        boolean isCommandParameter = field.isAnnotationPresent(CmdParam.class);

        if(!isCommandParameter)
            throw new AnnotationValidationException(field.getName() + " should be annotated by " + CmdParam.class.getName() + " or " + Transient.class.getName());

        return true;
    }
}
