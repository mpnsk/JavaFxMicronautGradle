package randomBeans;

import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Prototype;
import javafx.stage.Stage;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Example of creating a Bean of a class you don't own
 */
@Factory
public class SecondStageFactory {

    @Named("second")
    @Prototype
    public Stage getStage() {
        Stage stage = new Stage();
        stage.setTitle("2nd");
        return stage;
    }
}
