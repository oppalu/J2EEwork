package com.phoebe.Action;

import com.phoebe.Model.Score;
import com.phoebe.Model.Student;
import com.phoebe.Service.UserService;
import com.phoebe.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by phoebegl on 2017/2/23.
 */
@Controller
public class UserAction extends BaseAction {

    private UserService UserService = new UserServiceImpl();

    private Student student;

    private List<Score> score;

    public String execute() throws ServletException,IOException {

        if (UserService==null )System.out.println("user service null");

        String name = request.getParameter("uname");
        String password = request.getParameter("upass");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if(!(name == null || "".equals(name) || password == null || "".equals(password))) {
            student = UserService.findStudent(name,password);
            if(student.getName() != null) {
                score = UserService.getScore(student.getId());
                session.put("student",student);
                session.put("score",score);
                return SUCCESS;
            } else {
                out.println("<html><body><h3>用户名或密码错误!</h3></body></html>");
                return INPUT;
            }
        } else {
            out.println("<html><body><h3>用户名或密码不能为空</h3></body></html>");
            return INPUT;
        }
    }

}
