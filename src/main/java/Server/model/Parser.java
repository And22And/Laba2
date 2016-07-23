package Server.model;

import Server.worker.Doer;

import java.util.ArrayList;

public class Parser{

    public static void callDoer(ArrayList str , ServerUser serverUser){

        Doer doer = null;
        Class classe;

        try {
            classe = Class.forName("Server.worker." + str.get(0));
            try {
                doer = (Doer)classe.newInstance();
            } catch (InstantiationException e) {

            } catch (IllegalAccessException e) {

            }

        } catch (ClassNotFoundException e) {

        }
        System.out.println(str.toString()); ///////////
        if(doer != null) doer.doAction(str, serverUser);
    }

}
