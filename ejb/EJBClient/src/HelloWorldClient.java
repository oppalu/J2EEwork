import test.HelloWorld;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * Created by phoebegl on 2017/2/14.
 */
public class HelloWorldClient {

    public static void main(String[] args) throws NamingException {
        HelloWorld hello = lookupRemoteStatelessEjbBean();
        System.out.println(hello);
        String s = hello.sayHello("phoebe");
        System.out.println(s);
    }

    private static HelloWorld lookupRemoteStatelessEjbBean() throws NamingException {
        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);
        final String appName = "";
        final String moduleName = "EJBTest_war_exploded";
        final String distinctName = "";
        final String beanName = "HelloWorldEJB";
        final String viewClassName = HelloWorld.class.getName();
        final String namespace = "ejb:" + appName + "/" + moduleName
                + "/" + distinctName + "/" + beanName + "!" + viewClassName;
        return (HelloWorld) context.lookup(namespace);
    }
}

