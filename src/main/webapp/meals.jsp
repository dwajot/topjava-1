<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<head>
    <title>Meals</title>

    <style type="text/css">
        .normal{
            color: green;
        }
        .exceeded {
            color: red;
        }
    </style>
</head>
<body>

<center>
    <h1>Meals</h1>

    <table border="1" cellpadding="8" cellspacing="0">
        <tr>
            <th width="120"><b>Description</b></th>
            <th width="120"><b>Calories</b></th>
            <th width="120"><b>Date</b></th>
        </tr>
        <c:forEach items="${meals}" var="meal">
            <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealWithExceed"/>
            <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
                <td>${meal.description}</td>
                <td>${meal.calories}</td>
                <td>${fn:formatDateTime(meal.dateTime)}</td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>
