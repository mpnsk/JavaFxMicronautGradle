package randomBeans;

import io.micronaut.context.annotation.Prototype;

@Prototype
public class MyBean {
    public MyBean() {
        System.out.println("MyBean.MyBean");
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
