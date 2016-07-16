package Client.control;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import Client.model.Send;

public class ControllerEdit {

    @FXML
    TextField regLogin;

    @FXML
    TextField regPass;

    @FXML
    TextField regPassCheck;

    public void endRegistration(){
        if(regPass.getText().equals(regPassCheck.getText())){
            Send.sendQueryRegistration(regLogin.getText(), regPass.getText());
            System.out.println(regLogin.getText() + " " + regPass.getText());
        }
    }

}
