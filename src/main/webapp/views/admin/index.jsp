<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="ru">
    <head>
        <meta charset="utf-8">
        <title>Админка</title>
    </head>
    <body>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/admin/statistics';"
                    value="Статистика"></p>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/admin/users';"
                    value="Пользователи"></p>
        <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/mainPage';"
                    value="На главную"></p>
    </body>
</html>