<%@ page import="com.example.spring_mvc_basic.servlet.repository.UserRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.spring_mvc_basic.servlet.domain.UserAccount" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserRepository userRepository = UserRepository.getInstance();
    List<UserAccount> users = userRepository.findAll();
%>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
    <body>
        <a href="/index.html">메인</a>
        <table>
            <thead>
                <th>id</th>
                <th>username</th>
                <th>age</th>
            </thead>
            <tbody>
            <%
                for (UserAccount user : users) {
                    out.write(" <tr>");
                    out.write(" <td>" + user.getId() + "</td>");
                    out.write(" <td>" + user.getUsername() + "</td>");
                    out.write(" <td>" + user.getAge() + "</td>");
                    out.write(" </tr>");
                }
            %>
            </tbody>
        </table>
    </body>
</html>