<%@ page import="cn.gjp0609.web.user_management.v2.entity.User" %>
<%@page import="javax.servlet.jsp.el.*" %>
<%@page import="javax.servlet.jsp.jstl.*" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: gjp06
  Date: 17.3.26
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset:utf-8");
    List<User> users = (List<User>) request.getAttribute("users");
    session.setAttribute("users", users);
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table border='solid red 1px' cellspacing=0>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>password</th>
        <th>age</th>
        <th>email</th>
        <th>address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <%
        for (int i = 0; i < users.size(); i++) {
            request.setAttribute("rt", i);
            String s = users.get(i).getId();
    %>

    <tr>
        <td>${users[rt].id }</td>
        <td>${users[rt].username }</td>
        <td>${users[rt].password }</td>
        <td>${users[rt].age }</td>
        <td>${users[rt].email }</td>
        <td>${users[rt].address }</td>

        <%--<td><a href="/usermgr/userUpdateAction?userid=${id}" >edit</a></td>--%>
        <%--<td><a href="userDeleteAction">delete</a></td>--%>
        <%--<%request.getRequestDispatcher("").forward(request,response);%>--%>
    </tr>
    <% }%>
</table>
</body>
</html>

