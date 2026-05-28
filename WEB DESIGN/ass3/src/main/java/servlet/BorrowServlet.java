package servlet;

import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.*;

public class BorrowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Book> books = (List<Book>) session.getAttribute("books");
        List<Borrow> borrows = (List<Borrow>) session.getAttribute("borrows");
        if (borrows == null) {
            borrows = new ArrayList<>();
        }

        String bookId = request.getParameter("bookId");
        String username = (String) session.getAttribute("username");

        for (Book b : books) {
            if (b.getId().equals(bookId) && b.isAvailable()) {
                b.setAvailable(false);
                borrows.add(new Borrow(username, bookId));
                break;
            }
        }
        session.setAttribute("borrows", borrows);
        response.sendRedirect("userDashboard.jsp");
    }
}
