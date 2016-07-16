package Client.control;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import Client.model.Send;

import java.io.IOException;

/**
 * Created by User on 12.07.2016.
 */
public class ControllerLobby {

    @FXML
    private ListView<String> list;

    @FXML
    private void initialize() {
        ObservableList<String> items = FXCollections.observableArrayList (
                "Andry", "Danil", "Dima", "Alex", "Alex", "Alex",
                "Alex", "Alex", "Alex", "Alex", "Alex", "Alex",
                "Alex", "Alex", "Alex", "Alex", "Alex", "Alex", "Alex", "Feia");
        list.setItems(items);
    }

    public void duelButton(ActionEvent actionEvent) throws IOException {
        String selectedItem = list.getSelectionModel().getSelectedItem();
        System.out.println(selectedItem.toString());
        Send.sendQueryDuel(selectedItem.toString());
        Stage stageTheLabelBelongs = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/xml/sample.fxml"));
        stageTheLabelBelongs.setScene(new Scene(root));
    }

}
