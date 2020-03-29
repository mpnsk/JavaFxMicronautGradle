package randomBeans;

import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Prototype;
import javafx.stage.Stage;

import javax.inject.Named;
import javax.inject.Singleton;

@Factory
public class SecondStageFactory {

    @Named("second")
    @Prototype
    public Stage getStage() {
        return new Stage();
    }
}
