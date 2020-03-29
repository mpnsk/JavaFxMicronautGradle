package firstController;

import framework.micronaut.FXMLLoaderCreator;
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
    public FirstController() {
        System.out.println("FirstController constructor");
    }

    public TextField textField;
    public Button button;
    public CheckBox reuseWindow;

    @Inject
    @Named("second")
    Stage secondStage;

    @Inject
    FXMLLoaderCreator fxmlLoaderCreator;

    int windowCounter = 1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button.setOnAction(this::buttonClick);
    }

    private void buttonClick(ActionEvent event) {
        System.out.println("textField.getText() = " + textField.getText());
        newScene();
    }

    private void newScene() {
        try {
            FXMLLoader fxmlLoader = fxmlLoaderCreator.create();
            Parent load = fxmlLoader.load(getClass().getResourceAsStream("/secondController/second.fxml"));

            Stage stage;
            if (reuseWindow.isSelected()) {
                stage = this.secondStage;
            } else {
                stage = new Stage();
                stage.setTitle(String.valueOf(windowCounter++));
            }

            stage.setScene(new Scene(load, 300, 275));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
