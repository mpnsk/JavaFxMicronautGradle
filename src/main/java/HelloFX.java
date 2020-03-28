import io.micronaut.context.ApplicationContext;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloFX extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        ApplicationContext micronautContext = ApplicationContext.run();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("start/start.fxml"));
        fxmlLoader.setControllerFactory(micronautContext::getBean); //  this asks Micronaut to create the Controller
        Parent load = fxmlLoader.load();
        Scene scene = new Scene(load, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}