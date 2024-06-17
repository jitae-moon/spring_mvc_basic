<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.spring_mvc_basic.servlet.domain.UserAccount" %>
<%@ page import="com.example.spring_mvc_basic.servlet.repository.UserRepository" %>
<%
    // request, response 사용 가능

    UserRepository userRepository = UserRepository.getInstance();

    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    UserAccount user = new UserAccount("test user", 20);
    userRepository.save(user);
%>
<html>
    <head>
        <meta charset="utf-8" />
    </head>
    <body>
        <ul>
            <li>id: <%=user.getId()%></li>
            <li>username: <%=user.getUsername()%></li>
            <li>age: <%=user.getAge()%></li>
        </ul>
        <a href="/index.html">Main</a>
    </body>
</html>