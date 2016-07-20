package Server.worker;

import Server.model.Server;
import Server.model.ServerUser;

import java.util.Vector;


/**
 * Created by Клиент on 12.07.2016.
 */
public class Lobby implements Doer{

    public static synchronized void LobbyChange(String change, String name) {
        String result;
        result = "<body>\n" +
                "    <metaInfo>LobbyChange</metaInfo>\n" +
                "    <change>"+ change + "</change>\n" +
                "    <name>"+ name + "</name>\n" +
                "</body>";
        for (int i = 0; i < Server.getConnectedUsers().size(); i++) {
            if(!Server.getConnectedUsers().get(i).getUser().getUserName().equals(name))
                Server.getConnectedUsers().get(i).send(result);
        }
    }

    @Override
    public void doAction(String[] parameters, ServerUser serverUser){
        Lobby.LobbyChange("addName", serverUser.getUser().getUserName());
        String str = "<body>\n" +
                "<metaInfo>" +"LobbyInitialize"+ "</metaInfo>";
        for(int i = 0; i < Server.getConnectedUsers().size(); i++) {
            str += "<name>" + Server.getConnectedUsers().get(i).getName() + "</name\n";
        }
        str += "</body>";
        serverUser.send(str);
    }

}
