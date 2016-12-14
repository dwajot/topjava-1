<%--
  Created by IntelliJ IDEA.
  User: Artem
  Date: 14.12.2016
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meals</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>

<center>
    <h1>Meals</h1>

    <table class="tg">
        <tr>
            <th width="120"><b>Description</b></th>
            <th width="120"><b>Calories</b></th>
            <th width="120"><b>Date</b></th>
            <th width="60"><b>Edit</b></th>
            <th width="60"><b>Delete</b></th>
        </tr>
        <%--@elvariable id="mealWithExceeds" type="java.util.List"--%>
        <c:forEach items="${mealWithExceeds}" var="meal">
            <tr>
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td>${meal.dateTime}</td>
                    <%--<td><a href="<c:url value='/edit/${user.id}'/>">Edit</a></td>--%>
                    <%--<td><a href="<c:url value='/remove/${user.id}'/>">Delete</a></td>--%>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
