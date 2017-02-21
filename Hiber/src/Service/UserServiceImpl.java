package Service;

import Factory.DaoFactory;
import Model.Score;
import Model.Student;

import java.util.List;

/**
 * Created by phoebegl on 2017/2/21.
 */
public class UserServiceImpl implements UserService {
    private static UserServiceImpl service = null;

    private UserServiceImpl() {}

    public static UserServiceImpl getInstance() {
        if(service == null)
            service = new UserServiceImpl();
        return service;
    }

    @Override
    public Student findStudent(String id, String password) {
        return DaoFactory.getUserDao().findStudent(id,password);
    }

    @Override
    public List<Score> getScore(String sid) {
        return DaoFactory.getUserDao().getScore(sid);
    }
}
