package com.kupal.skypeCommand.annotations;

import com.kupal.skypeCommand.annotations.process.ParameterConverter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defined object converter
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Converter {

    Class<? extends ParameterConverter> value();
}
