package Client.model;

import Client.view.Main;

import java.util.Vector;

/**
 * Created by User on 15.07.2016.
 */
public class Distribut extends Thread {


    private static Vector mMessageQueue = new Vector();

    public static void addMessage(String str){
        mMessageQueue.add(str);
    }

    public synchronized String newMessage() {
        if(mMessageQueue.size() != 0) {
            String message = (String) mMessageQueue.get(0);
            mMessageQueue.removeElementAt(0);
            System.out.println(message + " +1");
            return message;
        }
        return null;
    }

//    public  void send(String message){
//        System.out.println(message);
//        Main.send().println(message);
//        out.flush();
//    }

    @Override
    public void run(){
//        Main.send("ssss++++");
//        for(;;)
//            while (mMessageQueue != null) {
//                System.out.println("Хоть что-то");
//                String message = newMessage();
//                Main.send(message);
//            }
//        Main.send(" -- ");
        if (mMessageQueue != null) {
                System.out.println("Хоть что-то");
                String message = newMessage();
                Main.send(message);
            }

    }

}
