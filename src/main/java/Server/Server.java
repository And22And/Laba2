package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Клиент on 05.07.2016.
 */
public class Server{

    static ArrayList<User> all;

    public static void removeUser(User user) {
        all.remove(user);
    }

    public static void main(String[] args) {
        all = new ArrayList<>();
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
                User user = new User(client);
                all.add(user);
                user.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
