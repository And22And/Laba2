package Server.worker;

import Server.model.ServerUser;

import java.util.ArrayList;

/**
 * Created by User on 29.07.2016.
 */
public class SuccessDraw implements Doer {
    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        String result;
        result = "<body>\n" +
                "    <metaInfo>SuccessDraw</metaInfo>\n" +
                "</body>";
        serverUser.getOponent().send(result);
    }
}
