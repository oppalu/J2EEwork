package Dao.Impl;

import Dao.UserDao;
import Model.Score;
import Model.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by phoebegl on 2017/2/19.
 */
@Stateless(name = "UserDaoEJB")
public class UserBean implements UserDao {

    @PersistenceContext
    private EntityManager em;

    public UserBean() {
    }

    @Override
    public Student findStudent(String id, String password) {
        Student s = em.find(Student.class,id);
        if(s.getPassword().equals(password)) {
            return s;
        }
        return null;
    }

    @Override
    public List<Score> getScore(String sid) {
        List<Score> query = em.createQuery("SELECT s FROM Score s WHERE s.sid = "+sid, Score.class).getResultList();
        return query;
    }
}
