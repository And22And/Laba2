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
    public void doAction(String[] parameters, ServerUser serverUser) {
        ArrayList<User> users = Server.getAllUsers().getUsers();
        boolean isExist = false;
        String result;
        for(int i = 0; i < users.size(); i++) {
            if(parameters[1].equals(users.get(i).getUserName())) {
                isExist = true;

                result = "<body>\n" +
                        "    <metaInfo>CheckInitialize</metaInfo>\n" +
                        "    <isExist>"+ true + "</isExist>\n" +
                        "    <right>"+ parameters[2].equals(users.get(i).getPasword()) + "</right>\n" +
                        "</body>";
                serverUser.send(result);
            }
        }
        if(!isExist) {
            result = "<body>\n" +
                    "    <metaInfo>CheckInitialize</metaInfo>\n" +
                    "    <isExist>"+ false + "</isExist>\n" +
                    "    <right>"+ false + "</right>\n" +
                    "</body>";
            serverUser.send(result);
        }
    }
}
