package Server.worker;

import Server.model.ServerUser;

import java.util.ArrayList;

/**
 * Created by User on 24.07.2016.
 */
public class Cancel implements Doer{

    private final static String result =  "<body>\n" +
            " <metaInfo>Cancel</metaInfo>\n" +
            "</body>";

    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        ServerUser tmp = serverUser.getOponent();
        serverUser.setOponent(null);
        tmp.setOponent(null);
        serverUser.setPlaing(false);
        tmp.setPlaing(false);
        tmp.send(result);
    }
}
