package Factory;

import Service.UserServiceImpl;

/**
 * Created by phoebegl on 2017/2/21.
 */
public class ServiceFactory {

    public static UserServiceImpl getUserService() {
        return UserServiceImpl.getInstance();
    }
}
