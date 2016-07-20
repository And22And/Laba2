package Client;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Клиент on 20.07.2016.
 */
public class LobbyChange {

    public void doAction(String parameters[]) {
        Method method = null;
        try {
            method = LobbyChange.class.getMethod(parameters[1], String[].class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        if(method != null) {
            try {
                method.invoke(this, parameters);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeName(String parameters[]) {
        //ArrayList<String> item = ControllerLobby.getLobby();
        //item.remove(parameters[2]);
        //ControllerLobby.setLobby(item);
    }

    public void addName(String parameters[]) {
        //ArrayList<String> item = ControllerLobby.getLobby();
        //item.add(parameters[2]);
        //ControllerLobby.setLobby(item);
    }

    public void changeStatus(String parameters[]) {

    }
}
