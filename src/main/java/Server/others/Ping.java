package Server.others;

import Server.model.Server;
import Server.model.ServerUser;
import Server.worker.Doer;

import java.util.ArrayList;

/**
 * Created by Клиент on 02.08.2016.
 */
public class Ping implements Doer {

    private static boolean reaction;
    private static ServerUser serverUser;

    public static boolean isReaction() {
        return reaction;
    }

    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        if(this.serverUser.equals(serverUser)) {
            reaction = true;
        }
    }

    public void chekUser(ServerUser serverUser) {
        reaction = false;
        String result;
        result = "<body>\n" +
                "    <metaInfo>Ping</metaInfo>\n" +
                "</body>";
        serverUser.send(result);
    }
}
