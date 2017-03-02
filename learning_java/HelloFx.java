import javafx.application.Application;
import javafx.stage.Stage;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;

/**
 * name
 */
public class HelloFx extends Application {

    public static void main(String[] args) {
        
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Hello JavaFx");
        Group group = new Group(new Label("Hello Lable"));
        Scene scene = new Scene(group, 300, 500);
        stage.setScene(scene);
        stage.show();
    }
}