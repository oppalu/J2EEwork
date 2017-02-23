package com.phoebe.Servlet;

import com.phoebe.Model.Student;
import com.phoebe.Service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by phoebegl on 2016/12/17.
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    private static ApplicationContext appliationContext;
    private static UserService userService;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        appliationContext=new ClassPathXmlApplicationContext("spring-config.xml");
        userService=(UserService)appliationContext.getBean("UserService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("uname");
        String password = request.getParameter("upass");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        if(!(name == null || "".equals(name) || password == null || "".equals(password))) {
            Student student = userService.findStudent(name,password);
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
