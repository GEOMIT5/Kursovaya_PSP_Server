package org.work.domen.com;

import org.work.domen.message.Message;

import java.io.Serializable;


public interface Com extends Serializable {

    Message execute(Message request);

}
