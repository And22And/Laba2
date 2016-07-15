package Server.model;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

import static java.util.Objects.isNull;

/**
 * Created by Клиент on 13.07.2016.
 */
public class ServerUser extends Thread{
    private User user;
    private User oponent;
    private boolean isPlaing;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ServerUser() {


    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ServerUser(Socket socket) {
        this.socket = socket;
        try {
            this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.out = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User getOponent() {
        return oponent;
    }

    public void setOponent(User oponent) {
        this.oponent = oponent;
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
        out.println(str);
        out.flush();
    }

    public String give() {
        String str = "";
        try {
            str = in.readLine();
        } catch (SocketException e) {
            try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        } catch (IOException  e) {
            e.printStackTrace();
        }
        return str;
    }

    @Override
    public void run() {
        while (!this.socket.isClosed()) {
            String str = give();
            if(!isNull(str))
                Parser.understandString(str);
        }
        Server.removeUser(this);
    }
}
