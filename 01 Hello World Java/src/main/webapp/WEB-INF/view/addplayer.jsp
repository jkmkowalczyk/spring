<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
Player to add:
<form:form method="post" modelAttribute="player" action="/players/add">
    <table>
        <tr>
            <td width="400px">
                <label><spring:message code="players.name"/>:<form:input path="name" type="text"/></label>
            </td>
            <td width="400px">
                <label><spring:message code="players.surname"/>:<form:input path="surname" type="text"/></label>
            </td>
        </tr>
        <tr>
            <td>
                <form:errors path="name"/>
            </td>
            <td>
                <form:errors path="surname"/>
            </td>
        </tr>
    </table>
    <button type="submit" value="ADD">Add</button>

</form:form>

</body>
<head>
    <title>Title</title>
</head>
</html>
