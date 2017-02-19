package Dao;

import Factory.EJBFactory;
import Model.Student;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.naming.InitialContext;
import java.util.Properties;

/**
 * Created by phoebegl on 2017/2/19.
 */
public class test {

    private static UserDao dao;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        dao = EJBFactory.getEJB();
    }

    @Test
    public void testStudent() {
        Student s = dao.findStudent("141250037","123456");
        System.out.println(s.getName());
    }
}
