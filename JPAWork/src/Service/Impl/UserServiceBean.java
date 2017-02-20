package Service.Impl;

import Dao.UserDao;
import Factory.EJBFactory;
import Model.Score;
import Model.Student;
import Service.UserService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Created by phoebegl on 2017/2/15.
 */
@Stateless(name = "UserService")
public class UserServiceBean implements UserService {

    @EJB
    private UserDao dao = null;

    public UserServiceBean() {

//        dao = EJBFactory.getEJB();
    }

    @Override
    public Student findStudent(String id, String password) {
        return dao.findStudent(id,password);
    }

    @Override
    public List<Score> getScore(String sid) {
        return dao.getScore(sid);
    }
}
