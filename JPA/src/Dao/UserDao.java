package Dao;

import Model.Score;
import Model.Student;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by phoebegl on 2017/1/2.
 */
@Remote
public interface UserDao {

    Student findStudent(String id,String password);

    List<Score> getScore(String sid);
}
