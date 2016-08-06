package Server.worker;

import Server.model.Server;
import Server.model.ServerUser;
import Server.model.User;

import java.util.ArrayList;

/**
 * Created by User on 21.07.2016.
 */
public class QueryUser implements Doer {
    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        ArrayList<ServerUser> users = Server.getConnectedUsers();
        String result;
        for(ServerUser i : users ){
            if(i.getUser().getUserName().equals(parameters.get(1))){
                result = "<body>\n" +
                        "    <metaInfo>QueryUser</metaInfo>\n" +
                        "    <name>"+ i.getUser().getUserName() + "</name>\n" +
                        "    <game>"+ i.getUser().getPlayedGames() + "</game>\n" +
                        "    <wins>"+ i.getUser().getWins() + "</wins>\n" +
                        "    <loses>"+ i.getUser().getLoses() + "</loses>\n" +
                        "    <status>"+ i.isPlaing() + "</status>\n" +
                        "</body>";
                serverUser.send(result);
            }
        }
    }
}
