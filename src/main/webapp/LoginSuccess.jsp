<%--
  Created by IntelliJ IDEA.
  User: AVinash
  Date: 09-12-2020
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success Page</title>
</head>
<body>
<h3>Hi <%= request.getAttribute("user")%>,Login successful</h3>
<a href="login.jsp">Login Page</a>
</body>
</html>

