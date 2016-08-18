package Server.model;

import Server.worker.Lobby;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Клиент on 05.07.2016.
 */
public class Server{

    private ArrayList<ServerUser> connectedUsers;
    private UserList allUsers;

    public void removeUser(ServerUser serverUser) {
        Lobby.LobbyChange("LobbyRemoveName", serverUser.getUser().getUserName(), serverUser);
        connectedUsers.remove(serverUser);
    }

    public void addUser(ServerUser user) {
        connectedUsers.add(user);
    }

    public ArrayList<ServerUser> getConnectedUsers() {
        return connectedUsers;
    }

    public UserList getAllUsers() {
        return allUsers;
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.connectedUsers = new ArrayList<>();
        server.allUsers = UserJAXB.unmarshall();
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
                ServerUser user = new ServerUser(client, server);
                user.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
