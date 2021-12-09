package org.work.domen.rele;

import org.work.domen.com.Com;
import org.work.domen.com.factory.CommandFactory;
import org.work.domen.message.Message;




public class Rele {

    public Message doAction(Message message) {
        CommandFactory factory = CommandFactory.getInstance();
        Com command = factory.getCommand(message.getCommand());
        return command.execute(message);
    }
}
