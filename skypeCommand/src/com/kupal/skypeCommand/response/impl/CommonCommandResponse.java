package com.kupal.skypeCommand.response.impl;

import com.kupal.skypeCommand.annotations.Response;
import com.kupal.skypeCommand.command.Status;
import com.kupal.skypeCommand.response.CommandResponse;
import com.kupal.skypeCommand.util.StringUtils;

/**
 * Siarhei.Krauchenia
 * 16.12.2009
 */
@Response
public class CommonCommandResponse implements CommandResponse {

    protected String responseText;
    protected Status status;

    public CommonCommandResponse() {
        status = Status.SUCCESS;
    }

    public CommonCommandResponse(Throwable throwable) {
        status = Status.FAILURE;

        StringBuilder errorMessage = new StringBuilder("ERROR: " + (StringUtils.isEmpty(throwable.getMessage()) ? "" : throwable.getMessage()));

        if(StringUtils.isEmpty(errorMessage.toString())) {

            for (StackTraceElement traceElement : throwable.getStackTrace()) {
                errorMessage.append(traceElement.toString());
                errorMessage.append("\n");
            }
        }

        responseText = errorMessage.toString();
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
