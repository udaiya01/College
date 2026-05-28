<%
String role = (String) session.getAttribute("role");
if(!"user".equals(role)) { response.sendRedirect("login.jsp"); return; }
%>

<html><body>
<h2>User Dashboard</h2>
<form action="BookServlet" method="get">
  Search Book: <input name="keyword">
  <input type="submit" value="Search">
</form>
<a href="borrowHistory.jsp">View Borrow History</a>
<br><a href="login.jsp">Logout</a>
</body></html>