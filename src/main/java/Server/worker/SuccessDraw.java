package Server.worker;

import Server.model.Server;
import Server.model.ServerUser;
import Server.model.UserJAXB;

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
        ServerUser tmp = serverUser.getOponent();
        serverUser.setOponent(null);
        tmp.setOponent(null);
        serverUser.setPlaing(false);
        tmp.setPlaing(false);
        serverUser.getUser().draw();
        tmp.getUser().draw();
        UserJAXB.marshall(serverUser.getServer().getAllUsers());
        (new UserInfo()).sendInfo(serverUser);
        (new UserInfo()).sendInfo(tmp);
        tmp.send(result);
    }
}
