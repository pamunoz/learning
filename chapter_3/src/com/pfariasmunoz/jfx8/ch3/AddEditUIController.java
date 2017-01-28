
package com.pfariasmunoz.jfx8.ch3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AddEditUIController extends BaseController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="newNotesBtn"
    private Button newNotesBtn; // Value injected by FXMLLoader

    @FXML // fx:id="cancelBtn"
    private Button cancelBtn; // Value injected by FXMLLoader

    @FXML // fx:id="clearBtn"
    private Button clearBtn; // Value injected by FXMLLoader

    @FXML // fx:id="saveBtn"
    private Button saveBtn; // Value injected by FXMLLoader

    @FXML
    void handleCancel(ActionEvent event) {

    }

    @FXML
    void handleClear(ActionEvent event) {

    }

    @FXML
    void handleNewNotes(ActionEvent event) {

    }

    @FXML
    void handleSave(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert newNotesBtn != null : "fx:id=\"newNotesBtn\" was not injected: check your FXML file 'AddEditUI.fxml'.";
        assert cancelBtn != null : "fx:id=\"cancelBtn\" was not injected: check your FXML file 'AddEditUI.fxml'.";
        assert clearBtn != null : "fx:id=\"clearBtn\" was not injected: check your FXML file 'AddEditUI.fxml'.";
        assert saveBtn != null : "fx:id=\"saveBtn\" was not injected: check your FXML file 'AddEditUI.fxml'.";

    }
}
