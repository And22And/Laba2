package Server.others;

import Server.model.Server;
import Server.model.ServerUser;

import java.util.ArrayList;

/**
 * Created by Клиент on 02.08.2016.
 */
public class ClientConnectionCheker extends Thread {

    @Override
    public void run() {
        while (true) {
            ArrayList<ServerUser> arr = Server.getConnectedUsers();
            Ping ping = new Ping();
            long timeStart;
            long timeEnd;
            for (int i = 0; i < arr.size(); i++) {
                timeStart = System.currentTimeMillis();
                timeEnd = System.currentTimeMillis();
                ping.chekUser(arr.get(i));
                while (Math.abs(timeStart - timeEnd) < 999 && !Ping.isReaction()) {
                    timeEnd = System.currentTimeMillis();
                }
                if (Math.abs(timeStart - timeEnd) > 999) {
                    arr.get(i).closeConection();
                }
            }
        }
    }

}
