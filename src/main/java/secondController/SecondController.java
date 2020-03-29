package secondController;

import io.micronaut.context.annotation.Prototype;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import firstController.FirstController;
import randomBeans.MyBean;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

@Prototype
public class SecondController implements Initializable {
    public Label label;
    @Inject
    FirstController controller;
    @Inject
    MyBean myBean;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText(controller.textField.getText() + " is the text");
    }
}
