package Server.model;

import Server.worker.Lobby;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import static java.util.Objects.isNull;

/**
 * Created by Клиент on 05.07.2016.
 */
public class Server{

    final private static Logger log = Logger.getLogger(Server.class);

    private ArrayList<ServerUser> connectedUsers;
    private UserList allUsers;

    public void removeUser(ServerUser serverUser) {
        if(serverUser.getUser() != null) {
            Lobby.LobbyChange("LobbyRemoveName", serverUser.getUser().getUserName(), serverUser);
        }
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
            log.info("Server started on port " + 4444);
        } catch (IOException e) {
            log.error(e);
        }
        while (!isNull(ss) && !ss.isClosed()) {
            try {
                Socket client = ss.accept();
                log.info("Connected " + client.toString());
                ServerUser user = new ServerUser(client, server);
                user.start();
            } catch (IOException e) {
                log.error(e);
            }
        }
    }


}
