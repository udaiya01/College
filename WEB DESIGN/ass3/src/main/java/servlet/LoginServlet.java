// LoginServlet.java
package servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession();

        if(username.equals("librarian") && password.equals("lib123")) {
            session.setAttribute("role", "librarian");
            session.setAttribute("username", username);
            response.sendRedirect("librarianDashboard.jsp");
        } else if(username.equals("user") && password.equals("user123")) {
            session.setAttribute("role", "user");
            session.setAttribute("username", username);
            response.sendRedirect("userDashboard.jsp");
        } else {
            response.sendRedirect("login.jsp?error=1");
        }
    }
}