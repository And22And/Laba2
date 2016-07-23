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
        ArrayList<User> users = Server.getAllUsers().getUsers();
        String result;
        for(User i : users ){
            if(i.getUserName().equals(parameters.get(1))){
                result = "<body>\n" +
                        "    <metaInfo>QueryUser</metaInfo>\n" +
                        "    <name>"+ i.getUserName() + "</name>\n" +
                        "    <game>"+ i.getPlayedGames() + "</game>\n" +
                        "    <wins>"+ i.getWins() + "</wins>\n" +
                        "    <status>"+ serverUser.isPlaing() + "</status>\n" +
                        "</body>";
                serverUser.send(result);
            }
        }
    }
}
