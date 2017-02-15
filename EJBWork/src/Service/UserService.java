package Service;

import Model.Score;
import Model.Student;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by phoebegl on 2017/1/4.
 */
@Remote
public interface UserService {

    Student findStudent(String id, String password);

    List<Score> getScore(String sid);
}
