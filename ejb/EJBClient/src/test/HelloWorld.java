package test;

import javax.ejb.Remote;

/**
 * Created by phoebegl on 2017/2/14.
 */
@Remote
public interface HelloWorld {

    public String sayHello(String name);
}
