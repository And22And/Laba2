package Server.worker;

import Server.model.ServerUser;
import Server.model.Server;

import java.util.ArrayList;

import static java.util.Objects.isNull;

/**
 * Created by User on 01.08.2016.
 */
public class Message implements Doer {
    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        String result;
        result = "<body>\n" +
                "    <metaInfo>Message</metaInfo>\n" +
                "    <name>" + serverUser.getUser().getUserName() + "</name>\n" +
                "    <text>" + parameters.get(1) + "</text>\n" +
                "</body>";
        if(!isNull(serverUser.getOponent())) {
            serverUser.getOponent().send(result);
        } else {
            for (int i = 0; i < serverUser.getServer().getConnectedUsers().size(); i++) {
                if(!serverUser.getServer().getConnectedUsers().get(i).getUser().getUserName()
                        .equals(serverUser.getUser().getUserName()) &&
                        !serverUser.getServer().getConnectedUsers().get(i).isPlaing())
                    serverUser.getServer().getConnectedUsers().get(i).send(result);
            }
        }
    }
}
