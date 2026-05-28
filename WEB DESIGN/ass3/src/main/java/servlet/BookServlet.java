package servlet;

import java.io.IOException;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import model.Book;

public class BookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Book> books = (List<Book>) session.getAttribute("books");
        if (books == null) {
            books = new ArrayList<>();
        }

        String id = request.getParameter("id");
        String title = request.getParameter("title");
        books.add(new Book(id, title));
        session.setAttribute("books", books);
        response.sendRedirect("librarianDashboard.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        HttpSession session = request.getSession();
        List<Book> books = (List<Book>) session.getAttribute("books");
        List<Book> results = new ArrayList<>();
        if (books != null) {
            for (Book b : books) {
                if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                    results.add(b);
                }
            }
        }
        session.setAttribute("searchResults", results);
        response.sendRedirect("search.jsp");
    }
}