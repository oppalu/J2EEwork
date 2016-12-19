package Servlet;

import Common.DataInit;

import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
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

/**
 * Created by phoebegl on 2016/12/17.
 *  实现：已登录用户，才能查看；
    未登录用户，转去登录；
    从登录提交到此的用户，创建session，跟踪登录状态；如果是来自初次登录的用户，则创建cookie；并查看成绩；
    通过刷新页面/或已创建session的页面访问，则查看自己的成绩。
 */

@WebServlet("/ShowScore")
public class ShowScoreServlet extends HttpServlet {

    private Connection conn = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            conn = DataInit.getDataSource().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);

        if(session == null) {
            response.sendRedirect(request.getContextPath()+"/Login.html");
        } else {
            String name = String.valueOf(request.getSession().getAttribute("username"));
            String id = String.valueOf(request.getSession().getAttribute("userid"));
            out.println("<html><body><h3>"+name+" "+id+"</h3><a href=\"/Logout\">注销</a><br>");
            out.println("<table border=\"1\"><tr>");
            out.println("<th>课程名称</th><th>成绩</th><th>详细说明</th></tr>");
            boolean allOk = true;
            try {
                PreparedStatement statement = conn.prepareStatement("SELECT * FROM course,exam WHERE id = cid AND sid=?");
                statement.setString(1,id);
                ResultSet result = statement.executeQuery();

                while(result.next()) {
                    if(result.getInt(6) == 0) {
                        allOk = false;
                    }
                    out.println("<tr>");
                    out.println("<td>"+result.getString(2)+"</td>");
                    out.println("<td>"+result.getInt(6)+"</td>");
                    out.println("<td>"+result.getString(7)+"</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(allOk == false) {
                out.println("<h3>注意您所选的课中有未参加的!</h3>");
            }
            out.println("</body></html>");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
