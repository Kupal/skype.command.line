package com.integrator.withparams;

import com.kupal.skypeCommand.annotations.process.ParameterConverter;

public class ServerTypeConverter implements ParameterConverter<ServerType> {

    public ServerType convert(String value) {
        return ServerType.valueOf(value);
    }
}
