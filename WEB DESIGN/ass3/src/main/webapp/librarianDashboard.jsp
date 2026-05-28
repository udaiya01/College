<%@ page import="java.util.*,model.Book" %>
<%
String role = (String) session.getAttribute("role");
if(!"librarian".equals(role)) { response.sendRedirect("login.jsp"); return; }
%>
<html><body>
<h2>Librarian Dashboard</h2>
<form action="BookServlet" method="post">
  Book ID: <input name="id"> Title: <input name="title">
  <input type="submit" value="Add Book">
</form>
<h3>Book List</h3>
<%
List<Book> books = (List<Book>) session.getAttribute("books");
if (books != null) {
  for (Book b : books) {
    out.println(b.getId() + " - " + b.getTitle() + " - " + (b.isAvailable()?"Available":"Borrowed") + "<br>");
  }
}
%>
<a href="login.jsp">Logout</a>
</body></html>