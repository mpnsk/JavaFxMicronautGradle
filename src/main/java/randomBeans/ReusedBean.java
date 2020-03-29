package randomBeans;

import io.micronaut.context.annotation.Prototype;

import javax.inject.Singleton;

/**
 * Example of a random Ben that gets reused
 */
@Singleton
public class ReusedBean {
    public ReusedBean() {
        System.out.println("ReusedBean constructor");
    }
}
