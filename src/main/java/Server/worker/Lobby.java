package Server.worker;

import Server.model.Server;
import Server.model.ServerUser;


/**
 * Created by Клиент on 12.07.2016.
 */
public class Lobby{

    public static synchronized void LobbyChange(String change, String name) {
        String result;
        result = "<body>\n" +
                "    <metaInfo>" + change +  "</metaInfo>\n" +
                "    <name>"+ name + "</name>\n" +
                "</body>";
        System.out.println("LobbyChange: " + result);
        for (int i = 0; i < Server.getConnectedUsers().size(); i++) {
            if(!Server.getConnectedUsers().get(i).getUser().getUserName().equals(name))
                Server.getConnectedUsers().get(i).send(result);
        }
    }


    public static void doAction(ServerUser serverUser){
        Lobby.LobbyChange("LobbyAddName", serverUser.getUser().getUserName());
        String str = "<body>\n" +
                "<metaInfo>" +"LobbyInitialize"+ "</metaInfo>\n";
        for(int i = 0; i < Server.getConnectedUsers().size(); i++) {
            str += "<name>" + Server.getConnectedUsers().get(i).getUser().getUserName() + "</name>\n";
        }
        str += "</body>";
        System.out.println(str);
        serverUser.send(str);
    }

}
