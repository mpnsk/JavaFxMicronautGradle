package beans;

import io.micronaut.context.annotation.Factory;
import javafx.stage.Stage;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Example of creating a Bean of a class you don't own
 */
@Factory
public class SecondStageFactory {

    @Named("second")
    @Singleton
    public Stage getStage() {
        Stage stage = new Stage();
        stage.setTitle("2nd");
        return stage;
    }
}
