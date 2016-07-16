package Client.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;


public class Main extends Application {

    public static Thread distribut;
    public static Socket socket;
    private static BufferedReader in;
    private static PrintWriter out;



    @Override
    public void start(Stage primaryStage) throws Exception{
        final Thread currentThread = Thread.currentThread();
        Parent root = FXMLLoader.load(getClass().getResource("/xml/sampleLogin.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
        try {
            this.socket = new Socket("localhost", 4444);
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out =  new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));

        } catch (IOException e) {
//            e.printStackTrace();
        } catch (Exception e) {
//            e.printStackTrace();
        }
//        Distribut distribut = new Distribut();
//        distribut.start();
//        this.distribut = distribut;

//        final Thread thread = new Thread(new Runnable() {
//            public void run() {
//                for(;;){
//
//                    Platform.runLater(distribut);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.getStackTrace();
//                    }
//                    if(currentThread.isInterrupted()){
//                        distribut.interrupt();
//                    }
//                }
//            }
//        });
//        thread.start();

        System.out.println(socket.isClosed());
        System.out.println(socket.isConnected());

    }

    public static BufferedReader getIn() {
        return in;
    }

    public static void setIn(BufferedReader in) {
        Main.in = in;
    }

    public static void send(String message){
        out.println(message);
        out.flush();
        System.out.println(message);
        System.out.println();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
