package Servlet;

import Common.DataInit;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
import java.sql.*;
import java.util.List;

/**
 * Created by phoebegl on 2016/12/17.
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    private Connection conn = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            conn = DataInit.getDataSource().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("uname");
        String password = request.getParameter("upass");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if(!(name == null || "".equals(name) || password == null || "".equals(password))) {
            try {
                PreparedStatement statement = conn.prepareStatement("SELECT * FROM student WHERE id=? AND password=?");
                statement.setString(1,name);
                statement.setString(2,password);
                ResultSet result = statement.executeQuery();

                if(result.next()) {
                    session.setAttribute("userid",name);
                    session.setAttribute("username",result.getString(2));
                    //登录成功后增加在线登录人数
                    ServletContext Context= getServletContext();
                    int counter= Integer.parseInt((String) Context.getAttribute("counter"));
                    int online= (Integer) Context.getAttribute("onlineCounter");
                    counter++;
                    online++;
                    Context.setAttribute("counter", Integer.toString(counter));
                    Context.setAttribute("onlineCounter",online);
                    response.sendRedirect(request.getContextPath()+"/ShowScore");
                } else {
                    out.println("<html><body><h3>用户名或密码错误!</h3><a href=\"Login.html\">请重新登录</a></body></html>");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            out.println("<html><body><h3>用户名或密码不能为空</h3><a href=\"/\">返回登录页</a></body></html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
