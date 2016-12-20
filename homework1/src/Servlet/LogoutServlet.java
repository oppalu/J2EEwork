package Servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by phoebegl on 2016/12/19.
 */
@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ServletContext Context= getServletContext();
        int online= (Integer) Context.getAttribute("onlineCounter");
        online--;
        Context.setAttribute("onlineCounter",online);
        session.invalidate();
        response.sendRedirect(request.getContextPath()+"/Login.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
