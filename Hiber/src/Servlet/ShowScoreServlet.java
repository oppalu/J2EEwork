package Servlet;

import Factory.ServiceFactory;
import Model.Score;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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

    private Connection conn = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        int counter= Integer.parseInt((String) getServletContext().getAttribute("counter"));
        int online= (Integer) getServletContext().getAttribute("onlineCounter");

        if(session == null) {
            response.sendRedirect(request.getContextPath()+"/");
        } else {
            String name = String.valueOf(request.getSession().getAttribute("username"));
            String id = String.valueOf(request.getSession().getAttribute("userid"));
            out.println("<html><body><h3>"+name+" "+id+"</h3><a href=\"/Logout\">注销</a><br>");
            out.println("<div>你是第"+counter+"个访问者</div>");
            out.println("<div>你是第"+online+"个在线用户</div>");
            out.println("<table border=\"1\"><tr><th>课程名称</th><th>成绩</th><th>详细说明</th></tr>");
            boolean allOk = true;
            List<Score> score = ServiceFactory.getUserService().getScore(id);

            for(int i = 0;i<score.size();i++) {
                Score s = score.get(i);
                if(s.getScore() == 0) {
                    allOk = false;
                }
                out.println("<tr>");
                out.println("<td>"+s.getCoursename()+"</td>");
                out.println("<td>"+s.getScore()+"</td>");
                out.println("<td>"+s.getDetail()+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");

            if(allOk == false) {
                out.println("<h3>注意您所选的课中有未参加的!</h3>");
            }
            out.println("</body></html>");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
