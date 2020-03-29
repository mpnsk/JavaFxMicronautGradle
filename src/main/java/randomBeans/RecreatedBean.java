package randomBeans;

import io.micronaut.context.annotation.Prototype;

import javax.inject.Singleton;

/**
 * Example of a random Ben that gets created with every new scope
 */
@Prototype
public class RecreatedBean {
    public RecreatedBean() {
        System.out.println("RecreatedBean constructor");
    }
}
