package Server.model;

import javax.xml.bind.JAXB;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Клиент on 05.07.2016.
 */
public class Server{

    public static ArrayList<ServerUser> connectedUsers;
    public static UserList allUsers;

    public static void removeUser(ServerUser user) {
        connectedUsers.remove(user);
    }

    public static void main(String[] args) {
        connectedUsers = new ArrayList<>();
        allUsers = UserJAXB.unmarshall();
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(4444);
            System.out.println("Server started on port " + 4444);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                Socket client = ss.accept();
                System.out.println("Connected " + client.toString());
                ServerUser user = new ServerUser(client);
                connectedUsers.add(user);
                user.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
