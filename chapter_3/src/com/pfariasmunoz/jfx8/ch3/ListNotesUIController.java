/**
 * Sample Skeleton for 'ListNotesUI.fxml' Controller Class
 */

package com.pfariasmunoz.jfx8.ch3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ListNotesUIController extends BaseController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="newNoteBtn"
    private Button newNoteBtn; // Value injected by FXMLLoader

    @FXML // fx:id="deleteNoteBtn"
    private Button deleteNoteBtn; // Value injected by FXMLLoader

    @FXML // fx:id="editNoteBtn"
    private Button editNoteBtn; // Value injected by FXMLLoader

    @FXML
    void handleDeleteNote(ActionEvent event) {

    }

    @FXML
    void handleEditNote(ActionEvent event) {

    }

    @FXML
    void handleNewNote(ActionEvent event) throws IOException {
        editNoteBtn = null;
        navigate(event, ADD.);

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert newNoteBtn != null : "fx:id=\"newNoteBtn\" was not injected: check your FXML file 'ListNotesUI.fxml'.";
        assert deleteNoteBtn != null : "fx:id=\"deleteNoteBtn\" was not injected: check your FXML file 'ListNotesUI.fxml'.";
        assert editNoteBtn != null : "fx:id=\"editNoteBtn\" was not injected: check your FXML file 'ListNotesUI.fxml'.";

    }
}
