package Server.worker;

import Server.model.ServerUser;

import java.util.ArrayList;

/**
 * Created by User on 25.07.2016.
 */
public class DoStep implements Doer {
    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        String result;
            result = "<body>\n" +
                    "    <metaInfo>DoStep</metaInfo>\n" +
                    "    <positionOf>"+ parameters.get(1) + "</positionOf>\n" +
                    "    <positionInto>"+ parameters.get(2) +"</positionInto>\n" +
                    "</body>";
            serverUser.getOponent().send(result);

    }
}
