package Factory;

import Dao.UserDao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

/**
 * Created by phoebegl on 2017/2/15.
 */
public class EJBFactory {

    public static UserDao getEJB() {

        final Hashtable<String, Object> jndiProps = new Hashtable<String, Object>();
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,"org.jboss.naming.remote.client.InitialContextFactory");
        jndiProps.put("jboss.naming.client.ejb.context", true);
        jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        try {
            final Context context = new InitialContext(jndiProps);

            final String appName = "";
            final String moduleName = "JPA";
            final String distinctName = "";
            final String beanName = "UserDaoEJB";
            final String viewClassName = UserDao.class.getName();
            final String namespace = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;

            return (UserDao)context.lookup("ejb:/JPA/UserDaoEJB!Dao.UserDao");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
