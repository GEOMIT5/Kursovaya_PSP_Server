package org.work.domen.server;


import org.work.domen.message.Message;


public interface Connection {

    void send(Message message);

    void close();
}
