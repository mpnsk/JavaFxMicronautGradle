package secondController;

import io.micronaut.context.annotation.Prototype;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import firstController.FirstController;
import randomBeans.MyBean;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.URL;
import java.util.ResourceBundle;

@Singleton
public class SecondController implements Initializable {
    public Label label;
    @Inject
    FirstController controller;
    @Inject
    MyBean myBean;

    public SecondController() {
        System.out.println("SecondController constructor");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText(controller.textField.getText() + " is the text");
    }
}
