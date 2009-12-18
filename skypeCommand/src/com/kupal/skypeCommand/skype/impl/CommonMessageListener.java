package com.kupal.skypeCommand.skype.impl;

import com.kupal.skypeCommand.command.CommandRunner;
import com.kupal.skypeCommand.skype.CommandMessageListener;
import com.skype.ChatMessage;
import com.skype.SkypeException;

/**
 * Common implementation
 * 
 * @author Kupal 3kb
 */
class CommonMessageListener implements CommandMessageListener {
    
    public void chatMessageReceived(ChatMessage chatMessage) throws SkypeException {
        String message = chatMessage.getContent();
        String responseMessage = CommandRunner.execute(message).getResponseText();
        chatMessage.getSender().send(responseMessage);
    }

    public void chatMessageSent(ChatMessage chatMessage) throws SkypeException {
        // do nothing
    }
}
