package com.kupal.skypeCommand;

import com.kupal.skypeCommand.skype.SkypeServer;
import com.kupal.skypeCommand.skype.impl.SkypeProfileFactory;

/**
 * Last modified by: $Author: skrauchenia $Revision: 117 $    $Date: 2009-03-17 13:28:15 +0200 (Tue, 17 Mar 2009) $
 */
public class Runner {

    public static void main(String[] args) {
        SkypeServer.start(SkypeProfileFactory.create());
        
    }
}
