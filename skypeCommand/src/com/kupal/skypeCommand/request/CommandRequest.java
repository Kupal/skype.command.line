package com.kupal.skypeCommand.request;

import com.kupal.skypeCommand.response.CommandResponse;

import java.util.Map;

/**
 * @author Kupal 3kb
 */
public interface CommandRequest {

    String COMMAND_NAME_PARAM = "CommandName";
    String COMMAND_LINE_PARAM = "CommandLine";

    Map<String, Object> getParams();
    void setParams(Map<String, Object> params);
    Object getParam(String key);
    void addParam(String key, Object value);
    String getCommandName();
    void setCommandName(String commandName);
    CommandResponse getResponse();
}
