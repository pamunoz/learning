/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfariasmunoz.jfx8.ch3;

import java.io.IOException;
import java.net.URL;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author pablo
 */
public class BaseController {
    
    protected void navigate(Event event, URL fxmlDocName) throws IOException {
        // Loading new fxml UI document
        Parent pageParent = FXMLLoader.load(fxmlDocName);
        // Creating new scene
        Scene scene = new Scene(pageParent);
        // get current stage
        Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        // Hide old stage
        appStage.hide(); // Optional
        // Set stage with new Scene
        appStage.setScene(scene);
        // Show up the stage
        appStage.show();
    }
    
}
