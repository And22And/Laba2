package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;


public class Main extends Application {
    private Stage stage;
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
        try {
            this.socket = new Socket("localhost", 4444);
            this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.out =  new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
        } catch (IOException e) {
//            e.printStackTrace();
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
