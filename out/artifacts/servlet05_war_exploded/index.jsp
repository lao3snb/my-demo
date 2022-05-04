<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2021/9/18
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h2>获取作用域</h2>
    <h4>获取request的作用域：<%=request.getAttribute("requestMsg")%></h4>
    <h4>获取session的作用域：<%=session.getAttribute("sessionMsg")%></h4>
  </body>
</html>
