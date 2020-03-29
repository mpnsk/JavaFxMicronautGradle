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
import randomBeans.MyBean;

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
    public CheckBox newWindowCheckbox;

    @Inject
    MyBean myBean;

    @Inject
    @Named("second")
    Stage stage;

    @Inject
    FXMLLoaderCreator fxmlLoaderCreator;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        button.setOnAction(this::buttonClick);
        System.out.println("myBean = " + myBean);
    }

    private void buttonClick(ActionEvent event) {
        System.out.println("textField.getText() = " + textField.getText());
        newScene();
    }

    private void newScene() {
        try {
            FXMLLoader fxmlLoader = fxmlLoaderCreator.create();
            Parent load = fxmlLoader.load(getClass().getResourceAsStream("../secondController/second.fxml"));

            Stage stage;
            if (newWindowCheckbox.isSelected())
                stage = new Stage();
            else
                stage = this.stage;

            stage.setScene(new Scene(load, 300, 275));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
