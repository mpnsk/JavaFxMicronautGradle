package beans;

import javax.inject.Singleton;

/**
 * Example of a random Bean that gets reused
 */
@Singleton
public class ReusedBean {
    public ReusedBean() {
        System.out.println("ReusedBean constructor");
    }
}
