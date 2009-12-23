package com.kupal.skypeCommand.request;

import com.kupal.skypeCommand.response.CommandResponse;
import com.skype.User;

import java.util.Map;

/**
 * @author Kupal 3kb
 */
public interface CommandRequest {

    @Deprecated
    String COMMAND_NAME_PARAM = "CommandName";

    /** name of parameter that introduce direct command string */
    String COMMAND_LINE_PARAM = "CommandLine";

    /** name of parameter that introduce internal vatiant of direct command string */
    String INTERNAL_COMMAND_LINE_PARAM = "InternalCommandLine";

    Map<String, Object> getParams();
    void setParams(Map<String, Object> params);

    /**
     * Getting parameter with specified name
     *
     * @param key - parameter name
     * @return parameter value
     */
    Object getParam(String key);

    /**
     * Add new paramenter or replace existed with same name
     * 
     * @param key - parameter name
     * @param value - parameter value
     */
    void addParam(String key, Object value);

    @Deprecated
    String getCommandName();

    @Deprecated
    void setCommandName(String commandName);

    /**
     * Getting appropriate respnse
     *
     * @return response
     */
    CommandResponse getResponse();

    /**
     * set sender of request
     *
     * @param sender of request
     */
    void setSender(User sender);

    /**
     * retrieve command sender
     * @return command sender
     */
    User getSender();
}
