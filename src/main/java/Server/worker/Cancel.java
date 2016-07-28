package Server.worker;

import Server.model.ServerUser;

import java.util.ArrayList;

/**
 * Created by User on 24.07.2016.
 */
public class Cancel implements Doer{
    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        String result;
        result = "<body>\n" +
                " <metaInfo>Cancel</metaInfo>\n" +
                "</body>";
        serverUser.getOponent().send(result);
        ServerUser tmp = serverUser.getOponent();
        serverUser.setOponent(null);
        tmp.setOponent(null);
    }
}