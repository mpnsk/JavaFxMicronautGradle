package start;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class StartController implements Initializable {
    public TextField textField;
    public Button button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button.setOnAction(this::buttonClick);
    }

    private void buttonClick(ActionEvent event) {
        System.out.println("textField.getText() = " + textField.getText());
    }
}
