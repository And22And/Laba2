package Server.worker;

import Server.model.Server;
import Server.model.ServerUser;
import Server.model.User;

import java.util.ArrayList;

/**
 * Created by User on 21.07.2016.
 */
public class Duel implements Doer {
    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        ArrayList<ServerUser> arrayUsers = Server.getConnectedUsers();
        String result;
        for (ServerUser y : arrayUsers) {
            if (y.getUser().getUserName().equals(parameters.get(1))) {
                serverUser.setOponent(y);// переделать так что опонентом был СерверЮзер
                y.setOponent(serverUser);
                result = "<body>\n" +
                        "    <metaInfo>CheckDuel</metaInfo>\n" +
                        "    <name>" + y.getUser().getUserName() + "</name>\n" +
                        "</body>";
                y.send(result);
            }
        }
    }




}
