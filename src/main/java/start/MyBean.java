package start;

import io.micronaut.context.annotation.Prototype;

@Prototype
public class MyBean {
    public String description = "instantiated by Micronaut";

    @Override
    public String toString() {
        return "MyBean{" +
                "description='" + description + '\'' +
                '}';
    }
}
