package randomBeans;

import io.micronaut.context.annotation.Prototype;

import javax.inject.Singleton;

@Prototype
public class MyBean {
    public MyBean() {
        System.out.println("MyBean constructor");
        this.description = "random bean instantiated by Micronaut";
    }

    public String description;

    @Override
    public String toString() {
        return "MyBean{" +
                "description='" + description + '\'' +
                '}';
    }
}
