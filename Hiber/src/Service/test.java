package Service;

import Factory.ServiceFactory;
import Model.Score;
import Model.Student;
import org.junit.Test;

import java.util.List;

/**
 * Created by phoebegl on 2017/2/21.
 */
public class test {

    @Test
    public void testStudent() {
        Student s = ServiceFactory.getUserService().findStudent("141250037","123456");
        System.out.println(s.getName());
    }

    @Test
    public void testScore() {
        List<Score> score = ServiceFactory.getUserService().getScore("141250037");
        for(Score s : score) {
            System.out.println(s.getScore()+" "+s.getDetail());
        }
    }
}
