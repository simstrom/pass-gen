import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class SplashView {
    StackPane pane = new StackPane();
    // StackPane parentContent = new StackPane();

    public SplashView(StackPane root) {
        init(root);
    }

    public void init(StackPane root) {
        Label logo = new Label("LOGO");
        logo.setFont(new Font("Arial", 30));
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().add(logo);
        root.getChildren().setAll(pane);

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
        fadeIn.setFromValue(0);
        fadeIn.setToValue(1);
        fadeIn.setCycleCount(1);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setCycleCount(1);

        fadeIn.play();

        fadeIn.setOnFinished((e) -> {
            fadeOut.play();
        });

        fadeOut.setOnFinished((e) -> {
            // switchstate to menustate implement logic from arcturus?
            MenuState menu = new MenuState(root);
            // Label welcome = new Label("Welcome!");
            // welcome.setFont(new Font("Arial", 30));
            // parentContent.setAlignment(Pos.CENTER);
            // parentContent.getChildren().add(welcome);
            // root.getChildren().setAll(parentContent);
        });
    }
}
