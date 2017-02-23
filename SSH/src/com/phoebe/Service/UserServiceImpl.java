package com.phoebe.Service;

import com.phoebe.Dao.UserDao;
import com.phoebe.Model.Score;
import com.phoebe.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by phoebegl on 2017/2/21.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Student findStudent(String id, String password) {
        return userDao.findStudent(id,password);
    }

    @Override
    public List<Score> getScore(String sid) {
        return userDao.getScore(sid);
    }
}
