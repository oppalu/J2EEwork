package Servlet;

import Model.Score;
import Service.Impl.UserServiceBean;
import Service.UserService;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by phoebegl on 2016/12/17.
 *  实现：已登录用户，才能查看；
    未登录用户，转去登录；
    从登录提交到此的用户，创建session，跟踪登录状态；如果是来自初次登录的用户，则创建cookie；并查看成绩；
    通过刷新页面/或已创建session的页面访问，则查看自己的成绩。
 */

@WebServlet("/ShowScore")
public class ShowScoreServlet extends HttpServlet {

    @EJB(beanName = "UserService")
    UserService user;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        int counter= (Integer) getServletContext().getAttribute("counter");
        int online= (Integer) getServletContext().getAttribute("onlineCounter");

        if(session == null) {
            response.sendRedirect(request.getContextPath()+"/");
        } else {
            String name = String.valueOf(request.getSession().getAttribute("username"));
            String id = String.valueOf(request.getSession().getAttribute("userid"));
            getServletContext().setAttribute("username",name);
            getServletContext().setAttribute("userid",id);
            getServletContext().setAttribute("score",user.getScore(id));
            response.sendRedirect("ShowScore.jsp");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
