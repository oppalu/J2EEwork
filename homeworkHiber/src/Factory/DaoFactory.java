package Factory;

import Dao.UserDaoImpl;
import Dao.UserDao;

/**
 * Created by phoebegl on 2017/1/4.
 */
public class DaoFactory {
    public static UserDao getUserDao() {
        return UserDaoImpl.getInstance();
    }
}
