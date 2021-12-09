package org.work.controller;


import org.work.controller.listener.ServerContextListener;
import org.work.domen.server.Server;


public class Controller {

    public static void main(String[] args) {
        ServerContextListener.getInstance().init();
        //
        Server server = new Server();
        server.startServer();
        //
        ServerContextListener.getInstance().destroy();
    }
}
