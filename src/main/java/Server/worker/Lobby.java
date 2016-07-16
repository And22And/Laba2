package Server.worker;

import Server.model.Server;

import java.util.Vector;


/**
 * Created by Клиент on 12.07.2016.
 */
public class Lobby{


    public static synchronized void doAction(String str) {
        for (int i = 0; i < Server.getConnectedUsers().size(); i++) {
            Server.getConnectedUsers().get(i).send(str);
        }
    }

    public static String getFullLobby(){
        String str = "<body>\n";
        for(int i = 0; i < Server.getConnectedUsers().size(); i++) {
            str += "<name>" + Server.getConnectedUsers().get(i).getName() + "</name\n";
        }
        str += "</body>";
        return str;
    }

}
