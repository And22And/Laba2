package Client;

import java.util.ArrayList;

/**
 * Created by Клиент on 20.07.2016.
 */
public class LobbyInitialize {

    public void doAction(String parameters[]) {
        ArrayList<String> lobby = new ArrayList<>();
        for(int i = 1; i < parameters.length; i++) {
            lobby.add(parameters[i]);
        }
        //ControllerLobby.setLobby(lobby);
    }
}
