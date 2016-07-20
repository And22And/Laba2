package Server.worker;

import Server.model.Server;
import Server.model.ServerUser;
import Server.model.User;

import java.util.ArrayList;

/**
 * Created by Клиент on 12.07.2016.
 */
public class CreateNewUser implements Doer {


    @Override
    public void doAction(String[] parameters, ServerUser serverUser) {
        ArrayList<User> users = Server.getAllUsers().getUsers();
        boolean isExist = false;
        String result;
        for(int i = 0; i < users.size(); i++) {
            if(parameters[1].equals(users.get(i).getUserName())) {
                isExist = true;
                result = "<body>\n" +
                        "    <metaInfo>CreateNewUser</metaInfo>\n" +
                        "    <isCreated>"+ true + "</isCreated>\n" +
                        "</body>";
                serverUser.send(result);
            }
        }
        if(!isExist) {
            Server.getAllUsers().add(parameters[0], parameters[1]);
            result = "<body>\n" +
                    "    <metaInfo>CreateNewUser</metaInfo>\n" +
                    "    <isCreated>"+ false + "</isCreated>\n" +
                    "</body>";
            serverUser.send(result);
        }
    }
}
