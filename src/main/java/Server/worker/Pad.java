package Server.worker;

import Server.model.ServerUser;

import java.util.ArrayList;

/**
 * Created by User on 02.08.2016.
 */
public class Pad implements Doer {
    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        String result;
        result = "<body>\n" +
                "    <metaInfo>Pad</metaInfo>\n" +
                "</body>";
        serverUser.getOponent().send(result);
    }
}
