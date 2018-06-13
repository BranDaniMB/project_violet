package gui.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author BranDaniMB
 */
public class InitMainGUI extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainWindows.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Menú");
        stage.setScene(scene);
        stage.show();
    }

}