package Server.model;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

import static java.util.Objects.isNull;

/**
 * Created by Клиент on 13.07.2016.
 */
public class ServerUser extends Thread{
    private User user;
    private int oponentId;
    private boolean isPlaing;
    private Socket socket;

    public ServerUser() {
        super();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ServerUser(Socket socket) {
        this.socket = socket;
    }


    public int getOponentId() {
        return oponentId;
    }

    public void setOponentId(int oponentId) {
        this.oponentId = oponentId;
    }

    public boolean isPlaing() {
        return isPlaing;
    }

    public void setPlaing(boolean plaing) {
        isPlaing = plaing;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void send(String str) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
            writer.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(!isNull(writer)) {
                writer.close();
            }
        }
    }

    public String give() {
        String str = "";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            str = reader.readLine();
        } catch (IOException  e) {
            e.printStackTrace();
        } finally {
            if(!isNull(reader)) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return str;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
          Parser.understandString(give());
        }
        Server.removeUser(this);
    }
}
