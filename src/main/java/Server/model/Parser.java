package Server.model;

import Server.worker.Doer;

public class Parser{

    public static void callDoer(String[] str , ServerUser serverUser){

        Doer doer = null;
        Class classe;

        try {
            classe = Class.forName("Server.worker." + str[0]);
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
