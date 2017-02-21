package Dao;

import Model.Score;
import Model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.hibernate.service.ServiceRegistry;

import java.util.List;

/**
 * Created by phoebegl on 2017/2/21.
 */
public class UserDaoImpl implements UserDao {

    private Configuration config;
    private ServiceRegistry serviceRegistry;
    private SessionFactory sessionFactory;
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
        Student s = null;
        config = new Configuration().configure();
        config.addAnnotatedClass(Student.class);
        serviceRegistry =new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();

        Query q = session.createQuery("from Student where id=:id and password=:pass").setParameter("id",id).setParameter("pass",password);
        s = (Student)q.uniqueResult();

        return s;
    }

    @Override
    public List<Score> getScore(String sid) {
        config = new Configuration().configure();
        config.addAnnotatedClass(Score.class);
        serviceRegistry =new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
        sessionFactory = config.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();

        Query q = session.createQuery("from Score where sid=:id").setParameter("id",sid);
        List<Score> s = q.list();

        return s;
    }
}
