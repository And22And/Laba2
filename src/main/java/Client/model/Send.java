package Client.model;

import Client.model.Distribut;
import Client.view.Main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

/**
 * Created by User on 12.07.2016.
 */
public class Send extends Thread{


    public static void sendStep(int of, int into) {
        String result;
        result = "<body>\n" +
                "    <metaInfo>DoStep</metaInfo>\n" +
                "    <positionOf>"+ of + "</positionOf>\n" +
                "    <positionInto>"+ into +"</positionInto>\n" +
                "</body>";
        Distribut.addMessage(result);

    }

    public static void sendQueryAboutIntlz(String login, String pass){
        String result;
        result = "<body>\n" +
                "    <metaInfo>CheckInitialize</metaInfo>\n" +
                "    <login>"+ login + "</login>\n" +
                "    <pass>"+ pass +"</pass>\n" +
                "</body>";
        Distribut.addMessage(result);
    }

    public static void sendQueryRegistration(String login, String pass){
        String result;
        result = "<body>\n" +
                "    <metaInfo>CreateNewUser</metaInfo>\n" +
                "    <login>"+ login + "</login>\n" +
                "    <pass>"+ pass +"</pass>\n" +
                "</body>";
        Distribut.addMessage(result);
    }





}
