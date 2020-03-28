package start;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.URL;
import java.util.ResourceBundle;

@Singleton
public class StartController implements Initializable {
    public TextField textField;
    public Button button;

    @Inject
    MyBean myBean;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button.setOnAction(this::buttonClick);
        System.out.println("myBean = " + myBean);
    }

    private void buttonClick(ActionEvent event) {
        System.out.println("textField.getText() = " + textField.getText());
    }
}
