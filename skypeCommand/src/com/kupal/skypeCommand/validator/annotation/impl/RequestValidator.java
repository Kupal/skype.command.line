package com.kupal.skypeCommand.validator.annotation.impl;

import com.kupal.skypeCommand.annotations.AnnotationUtil;
import com.kupal.skypeCommand.annotations.CmdParam;
import com.kupal.skypeCommand.annotations.Request;
import com.kupal.skypeCommand.exception.AnnotationValidationException;
import com.kupal.skypeCommand.validator.ValidatorHolder;
import com.kupal.skypeCommand.validator.annotation.AnnotationValidator;
import com.kupal.skypeCommand.request.CommandRequest;

import java.lang.reflect.Field;

/**
 * @author Kupal 3kb
 */
public class RequestValidator implements AnnotationValidator<Class<CommandRequest>> {

    public void validate(Class<CommandRequest> commandRequestClass) throws AnnotationValidationException {
        boolean isRequest = AnnotationUtil.getAnnotation(Request.class, commandRequestClass, true) != null;

        if(!isRequest)
            throw new AnnotationValidationException(commandRequestClass.getName() + " should be annotated by " + Request.class.getName());

        Field[] fields = commandRequestClass.getDeclaredFields();
        AnnotationValidator<Field> fieldValidator = (AnnotationValidator<Field>)ValidatorHolder.getValidator(CmdParam.class);

        for (Field field : fields) {
            fieldValidator.validate(field);
        }
    }
}
