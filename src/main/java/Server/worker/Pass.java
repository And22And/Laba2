package Server.worker;

import Server.model.Server;
import Server.model.ServerUser;
import Server.model.UserJAXB;

import java.util.ArrayList;

/**
 * Created by User on 29.07.2016.
 */
public class Pass implements Doer {

    private final static String result =  "<body>\n" +
            " <metaInfo>Pass</metaInfo>\n" +
            "</body>";

    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        serverUser.getUser().loser();
        serverUser.getOponent().getUser().winer();
        serverUser.setPlaing(false);
        serverUser.getOponent().setPlaing(false);
        ServerUser tmp = serverUser.getOponent();
        serverUser.setOponent(null);
        tmp.setOponent(null);
        UserJAXB.marshall(serverUser.getServer().getAllUsers());
        (new UserInfo()).doAction(null, serverUser);
        (new UserInfo()).doAction(null, tmp);
        tmp.send(result);
    }
}
