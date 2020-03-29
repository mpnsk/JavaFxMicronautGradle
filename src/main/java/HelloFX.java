import framework.micronaut.FXMLLoaderCreator;
import io.micronaut.context.ApplicationContext;
import io.micronaut.inject.qualifiers.Qualifiers;
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
        micronautContext.registerSingleton(Stage.class, stage, Qualifiers.byName("firstStage"));

        FXMLLoaderCreator loaderCreator = micronautContext.getBean(FXMLLoaderCreator.class);
        FXMLLoader fxmlLoader = loaderCreator.create();
        Parent load = fxmlLoader.load(getClass().getResourceAsStream("firstController/first.fxml"));
        Scene scene = new Scene(load, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}