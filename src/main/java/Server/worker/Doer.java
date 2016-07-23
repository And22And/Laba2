package Server.worker;

import Server.model.ServerUser;

import java.util.ArrayList;

/**
 * Created by Клиент on 12.07.2016.
 */
public interface Doer {

    public void doAction(ArrayList parameters, ServerUser serverUser);

}
