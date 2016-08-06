package Server.worker;

import Server.model.ServerUser;

import java.util.ArrayList;

/**
 * Created by Клиент on 04.08.2016.
 */
public class UserInfo implements Doer{
    public void sendInfo(ServerUser serverUser) {
        String result = "<body>\n" +
                " <metaInfo>UserInfo</metaInfo>\n" +
                " <name>" + serverUser.getUser().getUserName()+ "</name>\n" +
                " <game>" + serverUser.getUser().getPlayedGames()+ "</game>\n" +
                " <wins>" + serverUser.getUser().getWins()+ "</wins>\n" +
                " <loses>" + serverUser.getUser().getLoses()+ "</loses>\n" +
                "</body>";
        serverUser.send(result);
    }

    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        sendInfo(serverUser);
    }
}
