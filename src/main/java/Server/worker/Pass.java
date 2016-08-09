package Server.worker;

import Server.model.Server;
import Server.model.ServerUser;
import Server.model.UserJAXB;

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
        serverUser.getUser().loser();
        serverUser.getOponent().getUser().winer();
        serverUser.setPlaing(false);
        serverUser.getOponent().setPlaing(false);
        ServerUser tmp = serverUser.getOponent();
        serverUser.setOponent(null);
        tmp.setOponent(null);
        UserJAXB.marshall(serverUser.getServer().getAllUsers());
        (new UserInfo()).sendInfo(serverUser);
        (new UserInfo()).sendInfo(tmp);
        tmp.send(result);
    }
}
