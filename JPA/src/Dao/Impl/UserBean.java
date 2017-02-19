package Dao.Impl;

import Dao.UserDao;
import Model.Score;
import Model.Student;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

/**
 * Created by phoebegl on 2017/2/19.
 */
@Stateless(name = "UserDaoEJB")
public class UserBean implements UserDao{

    @PersistenceContext
    private EntityManager em;
//    @PersistenceUnit
//    private EntityManagerFactory factory;

    public UserBean() {
//        factory =  Persistence.createEntityManagerFactory("MyUnit");
//        em = factory.createEntityManager();
    }

    @Override
    public Student findStudent(String id,String password) {
        Student s = em.find(Student.class,id);
        if(s.getPassword().equals(password)) {
            return s;
        }
        return null;
    }

    @Override
    public List<Score> getScore(String sid) {
        StringBuffer sql = new StringBuffer("SELECT * FROM score WHERE sid = "+sid);
        List<Score> query = em.createQuery(sql.toString(),Score.class).getResultList();
        return query;
    }
}
