package com.kupal.skypeCommand.annotations.process.impl;

import com.kupal.skypeCommand.annotations.CmdParam;
import com.kupal.skypeCommand.annotations.AnnotationUtil;
import com.kupal.skypeCommand.annotations.process.AnnotationProcessorException;
import com.kupal.skypeCommand.command.SkypeCommand;
import com.kupal.skypeCommand.request.CommandRequest;
import com.kupal.skypeCommand.util.ClassUtil;
import com.kupal.skypeCommand.util.StringUtils;

import java.lang.reflect.Field;

/**
 * @author Kupal 3kb
 */
public class RequestProcessor extends AbstractProcessor<CommandRequest> {

    /**
     * Fills all fields with annotation @CmdParam and check if required field is not set
     *
     * @param commandRequest - command request
     * @return Command request with filled fields
     * @throws AnnotationProcessorException if required fields is not set
     */
    public CommandRequest process(CommandRequest commandRequest) throws AnnotationProcessorException {
        Class<? extends CommandRequest> requestClass = commandRequest.getClass();
        Field[] fields  = ClassUtil.getDeclaredFields(requestClass, true);
        String line     = (String)commandRequest.getParam(CommandRequest.INTERNAL_COMMAND_LINE_PARAM);

        for (Field field : fields) {
            if(AnnotationUtil.isTransient(field))
                continue;

            CmdParam param = field.getAnnotation(CmdParam.class);

            String paramName = StringUtils.isEmpty(param.name()) ? field.getName() : param.name();
            String paramValue = exposeParamValue(line, paramName);

            if(param.required() && StringUtils.isEmpty(paramValue))
                throw new AnnotationProcessorException("parameter <" + paramName + "> is required");

            super.setValueToField(field, commandRequest, paramValue, paramName);
        }

        return commandRequest;
    }

    private String exposeParamValue(String line, String paramName) {
        try {
            String[] params = line.split(SkypeCommand.PARAM_TOKEN);

            for (String param : params) {
                String[] keyValue = param.split(SkypeCommand.KEY_VALUE_SEPARATOR);

                if(keyValue.length != 2)
                    continue;

                if(keyValue[0].equalsIgnoreCase(paramName))
                    return keyValue[1];
            }

        } catch (Exception e) {
            return null;
        }

        return null;
    }
}
