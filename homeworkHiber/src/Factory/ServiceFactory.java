package Factory;

import Service.Impl.UserServiceImpl;

/**
 * Created by phoebegl on 2017/1/4.
 */
public class ServiceFactory {

    public static UserServiceImpl getUserService() {
        return UserServiceImpl.getInstance();
    }
}
