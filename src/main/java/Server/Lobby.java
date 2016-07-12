package Server;

import java.util.Vector;

/**
 * Created by Клиент on 12.07.2016.
 */
public class Lobby implements Doer{

    Vector<String> lobbyQueue;

    public String getStringFromQueue() {
        String str = lobbyQueue.get(0);
        lobbyQueue.remove(0);
        return str;
    }

    @Override
    public void doAction(String str) {
        if(lobbyQueue.size() != 0) {
            String string = getStringFromQueue();
            for (int i = 0; i < Server.all.size(); i++) {
                Server.all.get(i).send(str);
            }
        }
    }
}
