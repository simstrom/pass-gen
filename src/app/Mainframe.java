package app;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class Mainframe {
    private Integer passwordLength;
    private boolean upperCaseCriteria = false;
    private boolean lowerCaseCriteria = false;
    private boolean numbersCriteria = false;
    private boolean symbolsCriteria = false;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label options;

    @FXML
    private CheckBox upperCase;

    @FXML
    private CheckBox lowerCase;

    @FXML
    private CheckBox symbol;

    @FXML
    private CheckBox number;

    @FXML
    private Label length;

    @FXML
    private Spinner<Integer> spinner;

    @FXML
    private Slider slider;

    @FXML
    private Button generate;

    @FXML
    private TextField display;

    @FXML
    private Button copy;

    @FXML
    void onLowerCaseClick(ActionEvent event) {
        lowerCaseCriteria = this.lowerCase.isSelected();
    }

    @FXML
    void onNumbersClick(ActionEvent event) {
        numbersCriteria = this.number.isSelected();
    }

    @FXML
    void onSymbolsClick(ActionEvent event) {
        symbolsCriteria = this.symbol.isSelected();
    }

    @FXML
    void onUpperCaseClick(ActionEvent event) {
        upperCaseCriteria = this.upperCase.isSelected();
    }

    @FXML
    void onCopyBtnClick(ActionEvent event) {
        copyToClipboard(display.getText());
        copy.setText("Copied!");
    }

    @FXML
    void onGenerateBtnClick(ActionEvent event) {
        copy.setText("Copy");
        if (!checkEmptyCriteria()) {
            String password = randomPassword(passwordLength);
            display.setText(password);
        } else {
            display.setText("Please choose at least one criteria!");
        }
    }

    @FXML
    void setLength(MouseEvent event) {
        passwordLength = (int) slider.getValue();
        spinner.getValueFactory().setValue(passwordLength);
    }

    @FXML
    void setSpinnerLength(MouseEvent event) {
        passwordLength = spinner.getValueFactory().getValue();
        slider.setValue(passwordLength);
    }

    @FXML
    void initialize() {
        initSpinner();
    }

    private String randomPassword(int length) {
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // 1
        String lowerCase = "abcdefghijklmnopqrstuvwxyz"; // 2
        String symbols = "!#%&?#$/"; // 3
        String numbers = "0123456789"; // 4

        ArrayList<Integer> active = getActive();
        char[] password = new char[length];

        for (int i = 0; i < length; i++) {
            int type = (int) (Math.random() * active.size());
            if (active.get(type) == 1) {
                int rand = (int) (Math.random() * upperCase.length());
                password[i] = upperCase.charAt(rand);
            } else if (active.get(type) == 2) {
                int rand = (int) (Math.random() * lowerCase.length());
                password[i] = lowerCase.charAt(rand);
            } else if (active.get(type) == 3) {
                int rand = (int) (Math.random() * symbols.length());
                password[i] = symbols.charAt(rand);
            } else if (active.get(type) == 4) {
                int rand = (int) (Math.random() * numbers.length());
                password[i] = numbers.charAt(rand);
            }
        }
        return new String(password);
    }

    static void copyToClipboard(String s) {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent content = new ClipboardContent();
        content.putString(s);
        clipboard.setContent(content);
    }

    public void initSpinner() {
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30));
    }

    public boolean checkEmptyCriteria() {
        if (upperCaseCriteria == false && lowerCaseCriteria == false && numbersCriteria == false
                && symbolsCriteria == false) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Integer> getActive() {
        ArrayList<Integer> active = new ArrayList<Integer>();
        if (upperCaseCriteria == true)
            active.add(1);
        if (lowerCaseCriteria == true)
            active.add(2);
        if (symbolsCriteria == true)
            active.add(3);
        if (numbersCriteria == true)
            active.add(4);

        return active;
    }
}
