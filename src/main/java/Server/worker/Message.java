package Server.worker;

import Server.model.ServerUser;

import java.util.ArrayList;

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
        serverUser.getOponent().send(result);
    }
}
