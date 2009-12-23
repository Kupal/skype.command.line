package com.kupal.skypeCommand.skype.impl;

import com.kupal.skypeCommand.command.CommandRunner;
import com.kupal.skypeCommand.skype.CommandMessageListener;
import com.skype.ChatMessage;
import com.skype.SkypeException;
import com.skype.User;

/**
 * Common implementation
 * 
 * @author Kupal 3kb
 */
class CommonMessageListener implements CommandMessageListener {
    
    public void chatMessageReceived(ChatMessage chatMessage) throws SkypeException {
        String message = chatMessage.getContent();
        User sender = chatMessage.getSender();
        String responseMessage = CommandRunner.execute(sender, message).getResponseText();
        sender.send(responseMessage);
    }

    public void chatMessageSent(ChatMessage chatMessage) throws SkypeException {
        // do nothing
    }
}
