import framework.micronaut.MicronautFXMLLoader;
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
        // start the dependency injection context
        ApplicationContext micronautContext = ApplicationContext.run();

        // registers with qualifier you can get the original Stage with `@Inject @Named("first") Stage stage;`
        micronautContext.registerSingleton(Stage.class, stage, Qualifiers.byName("first"));

        // gets an FXMLLoaderCreator like `@Inject FXMLLoaderCreator fxmlLoaderCreator` would do
        MicronautFXMLLoader loaderCreator = micronautContext.getBean(MicronautFXMLLoader.class);

        FXMLLoader fxmlLoader = loaderCreator.createLoader();
        Parent load = fxmlLoader.load(getClass().getResourceAsStream("/controllers/first.fxml"));
        Scene scene = new Scene(load, 640, 480);
        stage.setScene(scene);
        stage.setTitle("1st");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}