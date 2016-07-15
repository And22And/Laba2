package Server.model;


import Server.worker.Doer;
import jdk.internal.org.xml.sax.helpers.DefaultHandler;

public class Parser extends DefaultHandler{

    public static void understandString(String str){

        //Парсим строку str
        //Разбиваем на имя класса className
        //и параметры classParameters
        String className = "";
        String[] classParameters = new String[0];
        Doer doer = null;
        Class classe;

        try {
            classe = Class.forName("Server.worker." + className);
            try {
                doer = (Doer)classe.newInstance();
            } catch (InstantiationException ie) {

            } catch (IllegalAccessException iae) {

            }

        } catch (ClassNotFoundException cnfe) {

        }
        System.out.println(str);
        if(doer != null) doer.doAction(classParameters);
    }

}
