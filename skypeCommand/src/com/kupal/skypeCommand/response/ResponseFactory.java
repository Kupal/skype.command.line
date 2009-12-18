package com.kupal.skypeCommand.response;

import com.kupal.skypeCommand.response.impl.CommonCommandResponse;

/**
 * @author Kupal 3kb
 */
public class ResponseFactory {

    public static CommandResponse create() {
        return new CommonCommandResponse();
    }

    public static CommandResponse create(Throwable throwable) {
        return new CommonCommandResponse(throwable);
    }
}
