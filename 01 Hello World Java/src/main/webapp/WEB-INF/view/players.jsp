<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jkowalczyk
  Date: 13.03.2018
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<a href="/players/add">Add player</a>
<table>
    <c:forEach items="${players}" var="player">
        <tr>
            <td>${player}</td>
            <td>
                <form action="/players/delete" method="post">
                    <input type="hidden" name="name" value="${player.name}">
                    <input type="hidden" name="surname" value="${player.surname}">
                    <input type="submit" value="delete">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
