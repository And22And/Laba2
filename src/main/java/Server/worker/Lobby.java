package Server.worker;

import Server.model.Server;



/**
 * Created by Клиент on 12.07.2016.
 */
public class Lobby implements Doer{

//    Vector<String> lobbyQueue;
//
//    public String getStringFromQueue() {
//        String str = lobbyQueue.get(0);
//        lobbyQueue.remove(0);
//        return str;
//    }



    @Override
    public synchronized void doAction(String[] parameters) {
        for (int i = 0; i < Server.getConnectedUsers().size(); i++) {
            Server.getConnectedUsers().get(i).send(parameters[0]);
        }
    }
}
