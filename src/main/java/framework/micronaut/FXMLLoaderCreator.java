package framework.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.annotation.Prototype;
import javafx.fxml.FXMLLoader;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FXMLLoaderCreator {
    @Inject
    ApplicationContext micronautContext;

    public FXMLLoader create(){
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(micronautContext::getBean); // this asks Micronaut to create the Controller
        return fxmlLoader;
    }
}
