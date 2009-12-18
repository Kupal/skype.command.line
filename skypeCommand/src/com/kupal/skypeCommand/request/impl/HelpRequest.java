package com.kupal.skypeCommand.request.impl;

import com.kupal.skypeCommand.annotations.CmdParam;

/**
 * @author Kupal 3kb
 */
public class HelpRequest extends CommonCommandRequest {

    @CmdParam(required = false)
    private String cmd;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }
}
