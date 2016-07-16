package Client.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Client.model.Distribut;

import java.io.*;
import java.net.Socket;
import java.util.Vector;


public class Main extends Application {

    private Socket socket;
    private static BufferedReader in;
    private static PrintWriter out;



    @Override
    public void start(Stage primaryStage) throws Exception{
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
        Distribut distribut = new Distribut();
        distribut.start();

    }

    public static BufferedReader getIn() {
        return in;
    }

    public static void setIn(BufferedReader in) {
        Main.in = in;
    }

    public static PrintWriter getOut() {
        return out;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
