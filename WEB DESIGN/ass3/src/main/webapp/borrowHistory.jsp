<%@ page import="java.util.*,model.*" %>
<%
String role = (String) session.getAttribute("role");
if(!"user".equals(role)) { 
    response.sendRedirect("login.jsp"); 
    return; 
}
%>

<html><body>
<h2>Your Borrowing History</h2>
<%
List<Borrow> borrows = (List<Borrow>) session.getAttribute("borrows");
String username = (String) session.getAttribute("username");
if (borrows != null) {
  for (Borrow br : borrows) {
    if (br.getUsername().equals(username)) {
      out.println("Book ID: " + br.getBookId() + " Date: " + br.getBorrowDate() + "<br>");
    }
  }
}
%>
<a href="userDashboard.jsp">Back</a>
</body></html>