package Server.worker;

import Server.model.ServerUser;
import Server.model.Server;

import java.util.ArrayList;

import static java.util.Objects.isNull;

/**
 * Created by User on 01.08.2016.
 */
public class Message implements Doer {
    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        String result;
        if(parameters.get(1).equals("false")) {
            result = "<body>\n" +
                    "    <metaInfo>Message</metaInfo>\n" +
                    "    <transfer>" +  false + "</transfer>\n" +
                    "    <name>" + serverUser.getUser().getUserName() + "</name>\n" +
                    "    <text>" + parameters.get(2) + "</text>\n" +
                    "</body>";
        } else {
            result = "<body>\n" +
                    " <metaInfo>Message</metaInfo>\n" +
                    "    <transfer>" +  true + "</transfer>\n" +
                    "    <name>" + serverUser.getUser().getUserName() + "</name>\n" +
                    "    <text>" + parameters.get(2) + "</text>\n";
            StringBuilder sb = new StringBuilder(result);
            for(int i = 3; i < parameters.size(); i++)
                sb.append(" <textAdded>" + parameters.get(i) + "</textAdded>\n" );
            sb.append("</body>");
            result = sb.toString();
        }

        if(!isNull(serverUser.getOponent())) {
            serverUser.getOponent().send(result);
        } else {
            for (int i = 0; i < serverUser.getServer().getConnectedUsers().size(); i++) {
                if(!serverUser.getServer().getConnectedUsers().get(i).getUser().getUserName()
                        .equals(serverUser.getUser().getUserName()) &&
                        !serverUser.getServer().getConnectedUsers().get(i).isPlaing())
                    serverUser.getServer().getConnectedUsers().get(i).send(result);
            }
        }
    }
}
