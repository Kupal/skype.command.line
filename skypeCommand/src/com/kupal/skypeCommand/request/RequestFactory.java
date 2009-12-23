package com.kupal.skypeCommand.request;

import com.kupal.skypeCommand.request.impl.CommonCommandRequest;
import com.kupal.skypeCommand.util.ClassUtil;
import com.kupal.skypeCommand.util.StringUtils;
import com.kupal.skypeCommand.annotations.CmdParam;
import com.kupal.skypeCommand.command.SkypeCommand;

import java.lang.reflect.Field;

/**
 * @author Kupal 3kb
 */
public final class RequestFactory {

    /**
     * Creating new instance of Request
     *
     * @return request instance
     */
    public static CommandRequest create() {
        return new CommonCommandRequest();
    }

    /**
     * Creating new instance of Request and set command name param
     *
     * @param commandName - name of command
     * @return request instance
     * @deprecated
     */
    public static CommandRequest create(String commandName) {
        CommandRequest request = create();
        request.setCommandName(commandName);

        return request;
    }

    /**
     * Creating new instance of Request by specified class. Also setting
     * direct command line parameter and creating internal command line
     * parameter
     *
     * @param clazz of request
     * @param commandLine - direct command line
     * @param <T> type of request
     * @return request instance
     */
    public static <T extends CommandRequest> T create(Class<T> clazz, String commandLine) {
        T t = ClassUtil.getInstance(clazz);

        String caseInsensitiveCmdLine = commandLine.toUpperCase();

        t.addParam(T.COMMAND_LINE_PARAM, caseInsensitiveCmdLine);
        
        Field[] annotatedDeclaredFields = ClassUtil.getAnnotatedDeclaredFields(clazz, CmdParam.class, true);
        String internalCommandLine = caseInsensitiveCmdLine;

        for (Field field : annotatedDeclaredFields) {
            CmdParam param = field.getAnnotation(CmdParam.class);
            String paramName = StringUtils.isEmpty(param.name()) ? field.getName() : param.name();
            paramName = paramName.toUpperCase() + SkypeCommand.KEY_VALUE_SEPARATOR;
            internalCommandLine = internalCommandLine.replace(" " + paramName, SkypeCommand.PARAM_TOKEN + paramName);
        }

        t.addParam(T.INTERNAL_COMMAND_LINE_PARAM, internalCommandLine);
        return t;
    }
}
