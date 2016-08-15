package Server.worker;

import Server.model.ServerUser;

import java.util.ArrayList;

/**
 * Created by User on 29.07.2016.
 */
public class CancelDraw implements Doer {

    private final static String result =  "<body>\n" +
            "    <metaInfo>CancelDraw</metaInfo>\n" +
            "</body>";

    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        serverUser.getOponent().send(result);
    }
}
