package com.kupal.skypeCommand.request.impl;

import com.kupal.skypeCommand.request.CommandRequest;
import com.kupal.skypeCommand.response.CommandResponse;
import com.kupal.skypeCommand.response.ResponseFactory;
import com.kupal.skypeCommand.annotations.Transient;
import com.kupal.skypeCommand.annotations.Request;

import java.util.Map;
import java.util.HashMap;

/**
 * @author Kupal 3kb
 */
@Request
public class CommonCommandRequest implements CommandRequest {

    @Transient
    private Map<String, Object> params = new HashMap<String, Object>();

    public CommonCommandRequest() {

    }

    public CommonCommandRequest(String commandLine) {
        addParam(COMMAND_LINE_PARAM, commandLine);
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public Object getParam(String key) {
        return params.get(key);
    }

    public void addParam(String key, Object value) {
        params.put(key, value);
    }

    public String getCommandName() {
        Object commandName = getParam(CommandRequest.COMMAND_NAME_PARAM);
        return commandName == null ? null : commandName.toString();
    }

    public void setCommandName(String commandName) {
        addParam(CommandRequest.COMMAND_NAME_PARAM, commandName);
    }

    public CommandResponse getResponse() {
        return ResponseFactory.create();
    }
}
