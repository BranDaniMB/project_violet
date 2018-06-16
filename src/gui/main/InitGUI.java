package gui.main;

import game.Menu;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author BranDaniMB
 */
public class InitGUI extends Application {

    public ControllerGUI windowsController;
    private Stage stage;
    private AnchorPane rootPane;
    private final Menu menu = new Menu();

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        displayMainWindows();

    }

    public void displayMainWindows() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMainWindows.fxml"));
        this.rootPane = (AnchorPane) loader.load();

        Scene scene = new Scene(rootPane);
        this.stage.setTitle("Menú");
        this.stage.setScene(scene);
        this.windowsController = loader.getController();
        this.windowsController.setMainGUI(this);

        this.stage.show();
    }

    public void displaySelectionWindows() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSelectionTeam.fxml"));
        AnchorPane pane = (AnchorPane) loader.load();
        Stage windows = new Stage();
        windows.setTitle("Menú de selección");
        windows.initOwner(this.stage);
        Scene scene = new Scene(pane);

        windows.setScene(scene);
        this.windowsController = loader.getController();
        windowsController.setMainGUI(this);
        windows.show();
    }

    public void displayGame() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRoom1.fxml"));
        AnchorPane pane = (AnchorPane) loader.load();
        Stage windows = new Stage();
        windows.setTitle("room Escape");
        windows.initOwner(this.stage);
        Scene scene = new Scene(pane);

        windows.setScene(scene);
        this.windowsController = loader.getController();
        windowsController.setMainGUI(this);
        windows.show();
    }

    public Menu getMenu() {
        return this.menu;
    }

    @Override
    public void stop() {
        this.menu.saveAllData();
        System.out.println("stop.");
    }

    public void close() throws Exception {
        Platform.exit();
    }

}
