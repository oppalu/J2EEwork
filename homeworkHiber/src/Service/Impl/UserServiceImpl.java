package Service.Impl;

import Factory.DaoFactory;
import Model.Score;
import Model.Student;
import Service.UserService;

import java.util.List;

/**
 * Created by phoebegl on 2017/1/4.
 */
public class UserServiceImpl implements UserService{
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
