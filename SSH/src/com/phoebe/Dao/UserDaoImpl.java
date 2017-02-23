package com.phoebe.Dao;

import com.phoebe.Model.Score;
import com.phoebe.Model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by phoebegl on 2017/2/21.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Student findStudent(String id, String password) {
        Session session = sessionFactory.openSession();

        String hql = "from Student where id ="+id+" and password = "+password;
        Student s = (Student)session.createQuery(hql).uniqueResult();
        session.close();
        return s;
    }

    @Override
    public List<Score> getScore(String sid) {
        Session session = sessionFactory.openSession();
        String hql = "from Score where sid = "+sid;
        List<Score> s = session.createQuery(hql).list();
        session.close();
        return s;
    }
}
