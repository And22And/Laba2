package Server.worker;

import Server.model.ServerUser;

import java.util.ArrayList;

/**
 * Created by User on 29.07.2016.
 */
public class Pass implements Doer {
    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        String result;
        result = "<body>\n" +
                " <metaInfo>Pass</metaInfo>\n" +
                "</body>";
        serverUser.getOponent().send(result);
    }
}
