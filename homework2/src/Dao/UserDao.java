package Dao;

import Model.Score;
import Model.Student;

import java.util.List;

/**
 * Created by phoebegl on 2017/1/2.
 */
public interface UserDao {

    Student findStudent(String id,String password);

    List<Score> getScore(String sid);

}
