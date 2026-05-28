<html><body>
<h2>Login</h2>
<form action="LoginServlet" method="post">
  Username: <input name="username"><br>
  Password: <input type="password" name="password"><br>
  <input type="submit" value="Login">
</form>
<c:if test="${param.error == 1}"><p style="color:red">Invalid credentials</p></c:if>
</body></html>