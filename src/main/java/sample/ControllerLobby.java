package sample;

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

import java.io.IOException;

/**
 * Created by User on 12.07.2016.
 */
public class ControllerLobby {

    @FXML
    private static ListView<String> list;

    @FXML
    private void initialize() {
        ObservableList<String> items = FXCollections.observableArrayList (
                "Andry", "Danil", "Dima", "Alex", "Alex", "Alex", "Alex", "Alex", "Alex", "Alex", "Alex", "Alex", "Alex", "Alex", "Alex", "Alex", "Alex", "Alex", "Alex", "Feia");
        list.setItems(items);
    }

    public static ListView<String> getList() {
        return list;
    }

    public static void setList(ListView<String> list) {
        ControllerLobby.list = list;
    }

    public void duelButton(ActionEvent actionEvent) throws IOException {
        Stage stageTheLabelBelongs = (Stage) ((Button)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        stageTheLabelBelongs.setScene(new Scene(root));
    }

}
