package Client.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Client.model.*;
import java.io.IOException;

public class Controller2 {


    @FXML
    Button button;

    public void onClick() throws IOException {
        Stage stageTheLabelBelongs = (Stage) button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/xml/lobby.fxml"));
        stageTheLabelBelongs.setScene(new Scene(root));
    }

    public void onClickDialog(ActionEvent actionEvent){
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/xml/edit.fxml"));
            stage.setTitle("Hello World");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }
        catch (Exception e){
        }

    }

}
