package Dao.Impl;

import Dao.DBHelper;
import Dao.UserDao;
import Model.Score;
import Model.Student;

import javax.ejb.Stateless;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by phoebegl on 2017/2/15.
 */
@Stateless(name = "UserDaoEJB")
public class UserDaoBean implements UserDao {

    private DBHelper dbHelper = null;

    public UserDaoBean() {
        dbHelper = DBHelper.getDataInstance();
    }

    @Override
    public Student findStudent(String id, String password) {
        Connection conn=dbHelper.getConnection();
        Student result = new Student();
        PreparedStatement statement = null;
        ResultSet res = null;
        try {
            statement = conn.prepareStatement("SELECT * FROM student WHERE id=? AND password=?");
            statement.setString(1,id);
            statement.setString(2,password);
            res = statement.executeQuery();
            if(res.next()) {
                result.setId(id);
                result.setName(res.getString(2));
                result.setPassword(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbHelper.closeConnection();
            dbHelper.closePreparedStatement(statement);
            dbHelper.closeResult(res);
        }
        return result;
    }

    @Override
    public List<Score> getScore(String sid) {
        Connection conn=dbHelper.getConnection();
        List<Score> res = new ArrayList<>();
        PreparedStatement statement = null;
        ResultSet result = null;

        try {
            statement = conn.prepareStatement("SELECT * FROM course,exam WHERE id = cid AND sid=?");
            statement.setString(1,sid);
            result = statement.executeQuery();
            while(result.next()) {
                Score score = new Score(sid,result.getString(1),result.getString(2),result.getInt(3),
                        result.getDouble(6),result.getString(7));
                res.add(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbHelper.closeConnection();
            dbHelper.closePreparedStatement(statement);
            dbHelper.closeResult(result);
        }
        return res;
    }
}
