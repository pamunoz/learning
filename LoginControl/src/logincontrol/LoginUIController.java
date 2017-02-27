package logincontrol;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class LoginUIController {
    
    private Main mainApp;

    @FXML
    private TextField loginUserNameTextField;

    @FXML
    private PasswordField loginPasswordField;

    @FXML
    private CheckBox rememberChbox;

    @FXML
    private Button resetBtn;

    @FXML
    private Button loginBtn;

    
    
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    void doLogin(ActionEvent event) {

    }

    @FXML
    void doLoginPassword(ActionEvent event) {

    }

    @FXML
    void doLoginUserName(ActionEvent event) {

    }

    @FXML
    void doRemember(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

}
