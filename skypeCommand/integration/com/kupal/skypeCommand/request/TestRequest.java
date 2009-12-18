package com.kupal.skypeCommand.request;

import com.kupal.skypeCommand.request.impl.CommonCommandRequest;
import com.kupal.skypeCommand.annotations.CmdParam;

/**
 * @author Kupal 3kb
 */
public class TestRequest extends CommonCommandRequest {

    @CmdParam
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
