package Server.worker;

import Server.model.ServerUser;


/**
 * Created by Клиент on 12.07.2016.
 */
public class Lobby{

    public static void LobbyChange(String change, String name, ServerUser serverUser) {
        String result;
        result = "<body>\n" +
                "    <metaInfo>" + change +  "</metaInfo>\n" +
                "    <name>"+ name + "</name>\n" +
                "</body>";
        for (int i = 0; i < serverUser.getServer().getConnectedUsers().size(); i++) {
            if(!serverUser.getServer().getConnectedUsers().get(i).getUser().getUserName().equals(name))
                serverUser.getServer().getConnectedUsers().get(i).send(result);
        }
    }


    public static void doAction(ServerUser serverUser){
        Lobby.LobbyChange("LobbyAddName", serverUser.getUser().getUserName(), serverUser);
        StringBuffer str = new StringBuffer("<body>\n" +
                "<metaInfo>" +"LobbyInitialize"+ "</metaInfo>\n");
        for(int i = 0; i < serverUser.getServer().getConnectedUsers().size(); i++) {
            str.append("<name>").append(serverUser.getServer().getConnectedUsers().get(i).getUser().getUserName()).append("</name>\n");
        }
        str.append("</body>");
        serverUser.send(str.toString());
    }

}
