package com.integrator.withparams;

import com.kupal.skypeCommand.annotations.CmdParam;
import com.kupal.skypeCommand.annotations.Converter;
import com.kupal.skypeCommand.annotations.ParameterValidator;
import com.kupal.skypeCommand.request.impl.CommonCommandRequest;

public class StartServerRequest extends CommonCommandRequest {

    @CmdParam
    @ParameterValidator(ServerTypeValidator.class)
    @Converter(ServerTypeConverter.class)
    private ServerType type;

    public ServerType getType() {
        return type;
    }

    public void setType(ServerType type) {
        this.type = type;
    }
}
