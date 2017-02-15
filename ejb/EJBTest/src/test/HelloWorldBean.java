package test;

import javax.ejb.Stateless;

/**
 * Created by phoebegl on 2017/2/14.
 */
@Stateless(name = "HelloWorldEJB")
public class HelloWorldBean implements HelloWorld

{
    public HelloWorldBean() {
    }

    @Override
    public String sayHello(String name) {
        return "Hello "+name;
    }
}
