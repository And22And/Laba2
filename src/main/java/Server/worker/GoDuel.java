package Server.worker;

import Server.model.Server;
import Server.model.ServerUser;

import java.util.ArrayList;

/**
 * Created by Клиент on 20.07.2016.
 */
public class GoDuel implements Doer {

    @Override
    public void doAction(String[] parameters, ServerUser serverUser) {
        Lobby.LobbyChange("changeStatus", serverUser.getUser().getUserName());
        ArrayList<ServerUser> users = Server.getConnectedUsers();
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getUser().getUserName().equals(parameters[1])) {
                String message = "<body>\n";
                //вызов на дуель
                users.get(i).send(message);
                break;
            }
        }
    }
}
