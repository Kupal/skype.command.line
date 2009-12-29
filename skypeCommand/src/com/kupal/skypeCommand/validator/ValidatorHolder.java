package com.kupal.skypeCommand.validator;

import com.kupal.skypeCommand.annotations.CmdParam;
import com.kupal.skypeCommand.annotations.Command;
import com.kupal.skypeCommand.annotations.Request;
import com.kupal.skypeCommand.annotations.Response;
import com.kupal.skypeCommand.validator.annotation.impl.CommandValidator;
import com.kupal.skypeCommand.validator.annotation.impl.ParameterValidator;
import com.kupal.skypeCommand.validator.annotation.impl.RequestValidator;
import com.kupal.skypeCommand.validator.annotation.impl.ResponseValidator;
import com.kupal.skypeCommand.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kupal 3kb
 */
public class ValidatorHolder {

    private static Map<Class<? extends Annotation>, Class<? extends Validator>> registeredValidators = new HashMap<Class<? extends Annotation>, Class<? extends Validator>>();

    static {
        registerValidator(CmdParam.class, ParameterValidator.class);
        registerValidator(Command.class, CommandValidator.class);
        registerValidator(Request.class, RequestValidator.class);
        registerValidator(Response.class, ResponseValidator.class);
    }

    public static Validator getValidator(Class<? extends Annotation> annotationClass) {
        return ClassUtil.getInstance(registeredValidators.get(annotationClass));
    }

    public static void registerValidator(Class<? extends Annotation> annotationClass, Class<? extends Validator> validatorClass) {
        registeredValidators.put(annotationClass, validatorClass);
    }
}
