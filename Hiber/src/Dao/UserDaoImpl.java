package Dao;

import Model.Score;
import Model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

/**
 * Created by phoebegl on 2017/2/21.
 */
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;
    private ServiceRegistry serviceRegistry;
    private Session session;
    private static UserDaoImpl userDao;

    private UserDaoImpl() {
    }

    public static UserDaoImpl getInstance() {
        if(userDao == null)
            userDao = new UserDaoImpl();
        return userDao;
    }

    @Override
    public Student findStudent(String id, String password) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(Student.class);
        config.configure();

        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();

        String hql = "from Student where id ="+id+" and password = "+password;
        Student s = (Student)session.createQuery(hql).uniqueResult();
        session.close();
        return s;
    }

    @Override
    public List<Score> getScore(String sid) {
        Configuration config = new Configuration();
        config.addAnnotatedClass(Score.class);
        config.configure();

        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
        String hql = "from Score where sid = "+sid;
        List<Score> s = session.createQuery(hql).list();
        session.close();
        return s;
    }
}
