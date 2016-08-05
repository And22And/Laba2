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
            for (int i = 0; i < Server.getConnectedUsers().size(); i++) {
                if(!Server.getConnectedUsers().get(i).getUser().getUserName()
                        .equals(serverUser.getUser().getUserName()) &&
                        !Server.getConnectedUsers().get(i).isPlaing())
                    Server.getConnectedUsers().get(i).send(result);
            }
        }
    }
}
