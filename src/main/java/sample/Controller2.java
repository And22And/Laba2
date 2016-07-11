package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Controller2 {

    @FXML
    Button button;

    public void onClick() throws IOException {
        Stage stageTheLabelBelongs = (Stage) button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stageTheLabelBelongs.setScene(new Scene(root, 900, 640));
    }
}
