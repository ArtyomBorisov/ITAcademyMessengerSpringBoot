<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="ru">
    <head>
        <meta charset="utf-8">
        <title>Главная страница</title>
    </head>
    <body>
        <h3>Мессенджер</h3>
        <c:if test="${!empty inf}">
            ${inf}
            <c:set value="" var="inf" scope="request"/>
        </c:if>
        <c:choose>
            <c:when test="${sessionScope.user != null}">
                <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/profile';"
                                    value="Просмотреть профиль"></p>

                <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/message';"
                    value="Отправить сообщение"></p>

                <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/chats';"
                    value="Просмотреть сообщения"></p>

                <c:if test="${sessionScope.user.login == 'admin'}">
                    <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/admin';"
                                        value="Админка"></p>
                </c:if>

                <form action="${pageContext.request.contextPath}/exit">
                    <p><input type="submit" value="Выйти"></p>
                </form>
            </c:when>
            <c:otherwise>
                <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/signUp';"
                    value="Зарегистрироваться"></p>

                <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/signIn';"
                    value="Войти"></p>
            </c:otherwise>
        </c:choose>
    </body>
</html>