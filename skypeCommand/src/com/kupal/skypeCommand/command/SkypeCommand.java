package com.kupal.skypeCommand.command;

import com.kupal.skypeCommand.annotations.Request;
import com.kupal.skypeCommand.annotations.Response;
import com.kupal.skypeCommand.exception.CommandException;
import com.kupal.skypeCommand.request.CommandRequest;
import com.kupal.skypeCommand.response.CommandResponse;

/**
 * @author Kupal 3kb
 */
@Request
@Response
public abstract class SkypeCommand<T extends CommandRequest> {

    public static final String CMD_FIRST_TOKEN = "/";
    public static final String PARAM_TOKEN = "-D";
    public static final String KEY_VALUE_SEPARATOR = "=";
    protected String name;

    public abstract CommandResponse execute(T request) throws CommandException;
}
