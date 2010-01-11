package com.integrator.withparams;

import com.kupal.skypeCommand.exception.ParameterValueValidationException;
import com.kupal.skypeCommand.validator.value.ParameterValueValidator;

import java.util.Arrays;

public class ServerTypeValidator implements ParameterValueValidator {

    public void validate(String value) throws ParameterValueValidationException {
        ServerType type = ServerType.valueOf(value);

        if(type == null)
            throw new ParameterValueValidationException("There is no server type <" + value + ">. \nValid servers: " + Arrays.toString(ServerType.values()));
    }
}
