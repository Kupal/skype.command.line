package com.kupal.skypeCommand.annotations;

import com.kupal.skypeCommand.validator.value.ParameterValueValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ParameterValidator {

    Class<? extends ParameterValueValidator> value();
}
