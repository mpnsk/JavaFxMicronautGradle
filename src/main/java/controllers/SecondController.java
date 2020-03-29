package controllers;

import io.micronaut.context.annotation.Prototype;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import beans.RecreatedBean;
import beans.ReusedBean;

import javax.inject.Inject;
import java.net.URL;
import java.util.ResourceBundle;

@Prototype
public class SecondController implements Initializable {
    public Label label;
    @Inject
    FirstController controller;
    @Inject
    RecreatedBean recreatedBean;
    @Inject
    ReusedBean singletonBean;

    public SecondController() {
        System.out.println("SecondController constructor");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label.setText(controller.textField.getText() + " is the text");
    }
}
