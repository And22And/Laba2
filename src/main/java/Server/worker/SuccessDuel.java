package Server.worker;

import Server.model.ServerUser;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by User on 24.07.2016.
 */
public class SuccessDuel implements Doer {

    @Override
    public void doAction(ArrayList parameters, ServerUser serverUser) {
        String result;
        serverUser.setColor((String) parameters.get(1));
        ServerUser oponent = serverUser.getOponent();
        Random random = new Random();
        boolean now;
        System.out.println(serverUser.getColor() + " " + oponent.getColor());
        System.out.println(oponent == serverUser);
        if(serverUser.getColor().equals(oponent.getColor())){
            System.out.println("--1--");
            now = random.nextBoolean();
            result = "<body>\n" +
                    " <metaInfo>Duel</metaInfo>\n" +
                    " <white>"+ now +"</white>\n" +
                    "</body>";
            serverUser.send(result);
            result = "<body>\n" +
                    " <metaInfo>Duel</metaInfo>\n" +
                    " <white>"+ !now +"</white>\n" +
                    "</body>";
            oponent.send(result);
            return;
        }


        if(serverUser.getColor().equals("random")
                && !oponent.getColor().equals("random") ){
            System.out.println("--2--");
            if(oponent.getColor().equals("white")){
                now = true;
            } else {
                now = false;
            }
            result = "<body>\n" +
                    " <metaInfo>Duel</metaInfo>\n" +
                    " <white>"+ !now +"</white>\n" +
                    "</body>";
            System.out.println(!now);
            serverUser.send(result);
            result = "<body>\n" +
                    " <metaInfo>Duel</metaInfo>\n" +
                    " <white>"+ now +"</white>\n" +
                    "</body>";
            System.out.println(now);
            oponent.send(result);
            return;
        }
        if(!serverUser.getColor().equals("random")
                && oponent.getColor().equals("random") ){
            System.out.println("--3--");
            if(serverUser.getColor().equals("white")){
                now = true;
            } else {
                now = false;
            }
            result = "<body>\n" +
                    " <metaInfo>Duel</metaInfo>\n" +
                    " <white>"+ now +"</white>\n" +
                    "</body>";
            serverUser.send(result);
            result = "<body>\n" +
                    " <metaInfo>Duel</metaInfo>\n" +
                    " <white>"+ !now +"</white>\n" +
                    "</body>";
            oponent.send(result);
            return;
        }
        if(serverUser.getColor().equals("white")
                && oponent.getColor().equals("black") ){
            System.out.println("--4--");
            result = "<body>\n" +
                    " <metaInfo>Duel</metaInfo>\n" +
                    " <white>"+ true +"</white>\n" +
                    "</body>";
            serverUser.send(result);
            result = "<body>\n" +
                    " <metaInfo>Duel</metaInfo>\n" +
                    " <white>"+ false +"</white>\n" +
                    "</body>";
            oponent.send(result);
            return;
        }
        if(oponent.getColor().equals("white")
                && serverUser.getColor().equals("black") ){
            System.out.println("--5--");
            result = "<body>\n" +
                    " <metaInfo>Duel</metaInfo>\n" +
                    " <white>"+ false +"</white>\n" +
                    "</body>";
            serverUser.send(result);
            result = "<body>\n" +
                    " <metaInfo>Duel</metaInfo>\n" +
                    " <white>"+ true +"</white>\n" +
                    "</body>";
            oponent.send(result);
            return;
        }
    }
}
