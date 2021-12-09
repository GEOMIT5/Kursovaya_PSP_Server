package org.work.domen.server;

public interface ConnectionListener {


    void connectionCreated(Connection c);

    void connectionClose(Connection c);

    void connectionException(Exception ex);
}
