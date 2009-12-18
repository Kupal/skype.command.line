package com.kupal.skypeCommand.command;

import com.kupal.skypeCommand.response.CommandResponse;
import com.kupal.skypeCommand.request.CommandRequest;
import com.kupal.skypeCommand.annotations.Command;
import com.kupal.skypeCommand.annotations.Request;
import com.kupal.skypeCommand.request.TestRequest;

/**
 * @author Kupal 3kb
 */
@Command(name = "TEST_CMD")
@Request(requestClass = TestRequest.class)
public class TestCommand extends SkypeCommand {
    
    public CommandResponse execute(CommandRequest request) {
        TestRequest testRequest = (TestRequest)request;

        CommandResponse response = testRequest.getResponse();
        response.setResponseText("name = " + testRequest.getName());
        return response;
    }
}
