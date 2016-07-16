package Client.model;

import Client.view.Main;

import java.io.PrintWriter;
import java.util.Vector;

/**
 * Created by User on 15.07.2016.
 */
public class Distribut extends Thread {

    private PrintWriter out = Main.getOut();

    private static Vector mMessageQueue = new Vector();

    public static void addMessage(String str){
        mMessageQueue.add(str);
//        System.out.println(mMessageQueue.toString());
    }



    @Override
    public void run(){
        System.out.println("Лог треда");
        while (true){
            if(mMessageQueue.size()!=0) {
                System.out.println("++++");
                System.out.println(mMessageQueue.toString());
                System.out.println("++++");
                String message = (String) mMessageQueue.get(0);
                mMessageQueue.removeElementAt(0);
                out.println(message);
                out.flush();
            }
        }
    }

}
