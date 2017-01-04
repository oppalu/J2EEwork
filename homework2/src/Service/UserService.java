package Service;

import Model.Score;
import Model.Student;

import java.util.List;

/**
 * Created by phoebegl on 2017/1/4.
 */
public interface UserService {

    Student findStudent(String id, String password);

    List<Score> getScore(String sid);
}
