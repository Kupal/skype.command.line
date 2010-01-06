package com.kupal.skypeCommand.annotations;

import com.kupal.skypeCommand.annotations.process.ParameterConverter;

/**
 * Defined object converter
 */
public @interface Converter {

    Class<? extends ParameterConverter> value();
}
