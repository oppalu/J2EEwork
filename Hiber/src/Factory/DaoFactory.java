package Factory;

import Dao.UserDao;
import Dao.UserDaoImpl;

/**
 * Created by phoebegl on 2017/1/4.
 */
public class DaoFactory {
    public static UserDao getUserDao() {
        return UserDaoImpl.getInstance();
    }
}
