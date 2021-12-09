package org.work.domen.server;


import java.io.*;
import java.net.Socket;


import org.work.domen.message.Message;
import org.work.domen.rele.Rele;


public class ConnectionListenerImpl implements Connection, Runnable {

    private boolean needToRun = true;
    //
    private Socket socket;

    private InputStream in;
    private OutputStream out;

    public ConnectionListenerImpl(Socket socket, ConnectionListener connectionListener) throws Exception {
        super();
        this.socket = socket;
        this.in = socket.getInputStream();
        this.out = socket.getOutputStream();

        Thread t = new Thread(this);
        t.setPriority(Thread.MIN_PRIORITY);
        t.start();
    }

    @Override
    public void send(Message message) {
        try {
            System.out.println("Сообщение отправлено");
            ObjectOutputStream objOut = new ObjectOutputStream(out);
            objOut.writeObject(message);
            objOut.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void close() {
        try {
            this.needToRun = false;
            this.socket.close();
            this.in.close();
            this.out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Сокет закрыт!");
        }
    }


    //основная функция работы сервера
    @Override
    public void run() {

        while (needToRun) {
            try {

                int amount = in.available();

                if (amount != 0) {

                    ObjectInputStream objIn = new ObjectInputStream(in);

                    Message msq = (Message) objIn.readObject();
//

                    readMessage(msq);

                } else {
                    Thread.sleep(300);
                }
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }


    private synchronized void readMessage(Message message) {
        Rele manager = new Rele();
        System.out.println(message.getCommand());

        Message responce = manager.doAction(message);
        send(responce);
    }
}