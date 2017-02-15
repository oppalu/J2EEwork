package Servlet;

import Model.Student;
import Service.Impl.UserServiceBean;
import Service.UserService;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;

/**
 * Created by phoebegl on 2016/12/17.
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    @EJB(beanName = "UserServiceEJB")
    UserService user;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("uname");
        String password = request.getParameter("upass");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        if(!(name == null || "".equals(name) || password == null || "".equals(password))) {
            Student student = user.findStudent(name,password);
            if(student.getName() != null) {
                session.setAttribute("userid",name);
                session.setAttribute("username",student.getName());
                //登录成功后增加在线登录人数
                ServletContext Context= getServletContext();
                int visitor= (Integer)Context.getAttribute("visitor");
                int online= (Integer) Context.getAttribute("onlineCounter");
                visitor--;
                online++;
                Context.setAttribute("visitor", visitor);
                Context.setAttribute("onlineCounter",online);
                response.sendRedirect(request.getContextPath()+"/ShowScore");
            } else {
                out.println("<html><body><h3>用户名或密码错误!</h3><a href=\"/\">请重新登录</a></body></html>");
            }
        } else {
            out.println("<html><body><h3>用户名或密码不能为空</h3><a href=\"/\">返回登录页</a></body></html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
