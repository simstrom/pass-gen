package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * TODO: Min/max length (input) + Fixed size (check) then (dropdown) TODO:
 * lowercase/Uppercase/symbols/numbers (checkboxes) TODO: Show / hide (toggle)
 * TODO: Generate (button) TODO: Copy to clipboard (button) TODO: Result (field)
 */
public class Main extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("mainframe.fxml"));
        primaryStage.setTitle("Password Generator");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
