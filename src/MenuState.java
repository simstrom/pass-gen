import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MenuState {
    StackPane parentContent = new StackPane();
    String password;

    public MenuState(StackPane root) {
        init(root);
    }

    public void init(StackPane root) {
        Label welcome = new Label("Welcome!");
        welcome.setFont(new Font("Arial", 30));

        TextField field = new TextField("Enter password length");

        Button btn1 = new Button("Generate Password");
        btn1.setOnAction((e) -> {
            int i = Integer.parseInt(field.getText());
            password = randomPassword(i);
            System.out.println(password);
        });

        Button btn2 = new Button("Quit");
        btn2.setOnAction((e) -> {
            System.exit(0);
        });

        VBox layout = new VBox(50, welcome, field, btn1, btn2);
        layout.setAlignment(Pos.CENTER);
        parentContent.getChildren().add(layout);
        root.getChildren().setAll(parentContent);
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%"; // These are the
                                                                                                    // characters the
                                                                                                    // password is based
                                                                                                    // on.
        char[] password = new char[length]; // Password is array of chars with the defined default length.
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length()); // rand saves a random number between 1 and length
                                                                     // of passwordSet string.
            password[i] = passwordSet.charAt(rand); // value of index at password set is saved in the array.
        }
        return new String(password);
    }
}
