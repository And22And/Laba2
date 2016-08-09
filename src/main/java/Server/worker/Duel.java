package Server.worker;

import Server.model.Server;
import Server.model.ServerUser;

import java.util.ArrayList;

/**
 * Created by User on 21.07.2016.
 */
public class Duel implements Doer {
    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        ArrayList<ServerUser> arrayUsers = serverUser.getServer().getConnectedUsers();
        String result;
        for (ServerUser y : arrayUsers) {
            if (y.getUser().getUserName().equals(parameters.get(1))) {
                if(y.isPlaing()) {
                    result = "<body>\n" +
                            " <metaInfo>Cancel</metaInfo>\n" +
                            "</body>";
                    serverUser.send(result);
                }
                else {
                    serverUser.setOponent(y);
                    y.setOponent(serverUser);
                    serverUser.setPlaing(true);
                    y.setPlaing(true);
                    serverUser.setColor((String) parameters.get(2));
                    result = "<body>\n" +
                            "    <metaInfo>CheckDuel</metaInfo>\n" +
                            "    <name>" + serverUser.getUser().getUserName() + "</name>\n" +
                            "</body>";
                    y.send(result);
                }
            }
        }
    }




}
