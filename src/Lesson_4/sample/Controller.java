package Lesson_4.sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML public TextArea textArea;
    @FXML public TextField textField;
    @FXML public MenuItem exit;

    public void SendMessage(ActionEvent actionEvent) {
        textArea.appendText("User: " + textField.getText() + "\n");
        textField.clear();
        textField.requestFocus();
    }

    public void closeProg(ActionEvent actionEvent) {
        Platform.exit();
    }
}
