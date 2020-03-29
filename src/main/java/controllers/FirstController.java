package controllers;

import framework.micronaut.MicronautFXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Singleton
public class FirstController implements Initializable {
    public TextField textField;
    public Button button;
    public CheckBox reuseWindow;
    @Inject
    @Named("second")
    Stage secondStage;
    @Inject
    MicronautFXMLLoader micronautFxmlLoader;
    int windowCounter = 1;

    public FirstController() {
        System.out.println("FirstController constructor");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button.setOnAction(this::buttonClick);
    }

    private void buttonClick(ActionEvent event) {
        System.out.println("textField.getText() = " + textField.getText());
        newScene();
    }

    private void newScene() {
        Stage stage;
        if (reuseWindow.isSelected()) {
            stage = this.secondStage;
        } else {
            stage = new Stage();
            stage.setTitle(String.valueOf(windowCounter++));
        }
        try {
            FXMLLoader fxmlLoader = micronautFxmlLoader.createLoader();
            Parent load = fxmlLoader.load(getClass().getResourceAsStream("/controllers/second.fxml"));
            stage.setScene(new Scene(load, 300, 275));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
