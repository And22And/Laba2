package Server.worker;

import Server.model.Server;
import Server.model.ServerUser;
import Server.model.UserJAXB;

import java.util.ArrayList;

/**
 * Created by User on 28.07.2016.
 */
public class Mate implements Doer {
    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        String result;
        result = "<body>\n" +
                "    <metaInfo>Mate</metaInfo>\n" +
                "</body>";

        serverUser.getUser().winer();
        serverUser.getOponent().getUser().loser();
        serverUser.setPlaing(false);
        serverUser.getOponent().setPlaing(false);
        ServerUser tmp = serverUser.getOponent();
        serverUser.setOponent(null);
        tmp.setOponent(null);
        UserJAXB.marshall(Server.getAllUsers());
        (new UserInfo()).sendInfo(serverUser);
        (new UserInfo()).sendInfo(tmp);
        serverUser.getOponent().send(result);
    }
}
