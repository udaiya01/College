<%@ page import="java.util.*,model.Book" %>
<%
String role = (String) session.getAttribute("role");
if(!"user".equals(role)) { 
    response.sendRedirect("login.jsp"); 
    return; 
}
%>

<html><body>
<h2>Search Results</h2>
<%
List<Book> results = (List<Book>) session.getAttribute("searchResults");
if (results != null) {
  for (Book b : results) {
    if (b.isAvailable()) {
%>
<form action="BorrowServlet" method="post">
  <%= b.getId() %> - <%= b.getTitle() %>
  <input type="hidden" name="bookId" value="<%= b.getId() %>">
  <input type="submit" value="Borrow">
</form>
<%
    } else {
      out.println(b.getId() + " - " + b.getTitle() + " (Borrowed)<br>");
    }
  }
}
%>
<a href="userDashboard.jsp">Back</a>
</body></html>
