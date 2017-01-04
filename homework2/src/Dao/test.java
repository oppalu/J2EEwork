package Dao;

import Dao.Impl.UserDaoImpl;
import Factory.DaoFactory;
import Model.Student;
import org.junit.Test;

/**
 * Created by phoebegl on 2017/1/4.
 */
public class test {

    private UserDaoImpl user = UserDaoImpl.getInstance();

    @Test
    public void testFind() {
        Student s = new Student();
        s = user.findStudent("141250037","123456");
        System.out.println(s.getId());
        System.out.println(s.getName());
        System.out.println(s.getPassword());
    }
}
