package Server.worker;

import Server.model.ServerUser;

import java.util.ArrayList;

/**
 * Created by User on 28.07.2016.
 */
public class Draw implements Doer {
    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        String result;
        result = "<body>\n" +
                "    <metaInfo>CheckDraw</metaInfo>\n" +
                "</body>";
        serverUser.getOponent().send(result);
    }
}
