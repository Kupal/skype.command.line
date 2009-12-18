package com.kupal.skypeCommand.response;

import com.kupal.skypeCommand.command.Status;

/**
 * @author Kupal 3kb
 */
public interface CommandResponse {

    String getResponseText();
    Status getStatus();
    void setResponseText(String text);
    void setStatus(Status status);
}
