package Server.worker;

import Server.model.ServerUser;

import java.util.ArrayList;

/**
 * Created by Клиент on 02.08.2016.
 */
public class Disconnected implements Doer{


    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        serverUser.closeConection();
    }
}
