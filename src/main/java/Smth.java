import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class Smth extends Application {

    Button button;
    Text text;
    TextField textField;
    Socket socket;

    BufferedReader in;
    BufferedWriter out;

    public static void main(String[] args) {

        launch(args);

    }

    public void start(final Stage primaryStage) throws Exception {
        try {
            this.socket = new Socket("localhost", 4444);
            this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.out =  new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        VBox layout = new VBox(20);

        this.button = new Button("Send");
        this.button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    Smth.this.out.write(1);
                    Smth.this.out.write(Smth.this.textField.getText());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        layout.getChildren().add(this.button);


        this.text = new Text("Empty");
        layout.getChildren().add(this.text);

        this.textField = new TextField();
        layout.getChildren().add(this.textField);

        Scene scene = new Scene(layout, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        while(true) {
            try {
                String str = null;
                str = this.in.readLine();
                this.text.setText(str);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
