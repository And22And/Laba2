package Server.worker;

import Server.model.Server;
import Server.model.ServerUser;
import Server.model.User;

import java.util.ArrayList;

/**
 * Created by Клиент on 12.07.2016.
 */
public class CheckInitialize implements Doer {

    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        ArrayList<User> users = Server.getAllUsers().getUsers();
        boolean isExist = false;
        boolean isConected = false;
        for(int i = 0; i < Server.getConnectedUsers().size(); i++) {
            if (Server.getConnectedUsers().get(i).getUser().getUserName().equals(parameters.get(1))) {
                isConected = true;
                break;
            }
        }
        String result;
        for(int i = 0; i < users.size() && !isConected; i++) {
            if (parameters.get(1).equals(users.get(i).getUserName())) {
                if (parameters.get(2).equals(users.get(i).getPasword())) {
                    isExist = true;
                    result = "<body>\n" +
                            "    <metaInfo>CheckInitialize</metaInfo>\n" +
                            "    <isExist>" + true + "</isExist>\n" +
                            "    <right>" + parameters.get(2).equals(users.get(i).getPasword()) + "</right>\n" +
                            "    <name>" + users.get(i).getUserName()+ "</name>\n" +
                            "    <game>" + users.get(i).getPlayedGames()+ "</game>\n" +
                            "    <wins>" + users.get(i).getWins()+ "</wins>\n" +
                            "    <loses>" + users.get(i).getLoses()+ "</loses>\n" +
                            "</body>";
                    serverUser.send(result);
                    if(parameters.get(2).equals(users.get(i).getPasword())) {
                        serverUser.setUser(users.get(i));
                        Lobby.doAction(serverUser);
                        Server.addUser(serverUser);
                    }
                    break;
                }
            }
        }
        if(!isExist) {
            result = "<body>\n" +
                    "    <metaInfo>CheckInitialize</metaInfo>\n" +
                    "    <isExist>"+ false + "</isExist>\n" +
                    "    <right>"+ false + "</right>\n" +   // ?
                    "</body>";
            serverUser.send(result);
        }
    }
}