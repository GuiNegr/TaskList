<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>READ</title>
</head>
<body>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>TASK</th>
            <th>STATUSTASK</th>
            
        </tr>
        <c:forEach var="tasks" items="${tasks}">
            <tr>
                <td>${tasks.id}</td>
                <td>${tasks.nametask}</td>
                <td>${tasks.statusTask}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>