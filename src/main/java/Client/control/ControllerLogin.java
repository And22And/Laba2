package Client.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Client.model.*;
import java.io.IOException;

public class ControllerLogin {


    @FXML
    TextField textLogin;

    @FXML
    TextField textPass;

    @FXML
    Button button;

    /**
     * Now we don't say about protocol.
     * That is why "Send.send...()" is commented.
     * When we speak about this, i change this method.
     * Actually I will commend source between "start" and "end".
     * And discommend "Send.send...()"
     * @throws IOException
     */
    public void onClick() throws IOException {
        Send.sendQueryAboutIntlz(textLogin.getText(), textPass.getText());
        System.out.println(textLogin.getText() + " " + textPass.getText());
        // start
        Stage stageTheLabelBelongs = (Stage) button.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/xml/lobby.fxml"));
        stageTheLabelBelongs.setScene(new Scene(root));
        //end
    }

    public void onClickDialog(ActionEvent actionEvent) throws Exception {

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
            throw e;
        }

    }

}
