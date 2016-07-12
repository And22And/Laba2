package Server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import static java.util.Objects.isNull;

public class User extends Thread implements Serializable{

    private int userId;
    private int oponentId;
    private String userName;
    private String pasword;
    private boolean isPlaing;
    private Socket socket;

    public User(Socket socket) {
        this.socket = socket;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOponentId() {
        return oponentId;
    }

    public void setOponentId(int oponentId) {
        this.oponentId = oponentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
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
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
            writer.write(str);
        } catch (IOException  e) {
            e.printStackTrace();
        } finally {
            if(!isNull(writer)) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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

    public ArrayList<User> getAllUsers() {
        ArrayList<User> userList = new ArrayList<>();
        /////
        /////
        return userList;
    }

    @Override
    public void run() {
        while (true) {
            Parser.understandString(give());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getUserId() != user.getUserId()) return false;
        if (isPlaing() != user.isPlaing()) return false;
        if (!getName().equals(user.getName())) return false;
        if (!getPasword().equals(user.getPasword())) return false;
        return getSocket().equals(user.getSocket());

    }

    @Override
    public int hashCode() {
        int result = getUserId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getPasword().hashCode();
        result = 31 * result + (isPlaing() ? 1 : 0);
        result = 31 * result + getSocket().hashCode();
        return result;
    }
}
