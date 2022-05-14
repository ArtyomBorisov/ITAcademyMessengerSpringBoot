<%@ page language="java"
        contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<html lang="ru">
    <head>
        <meta charset="utf-8">
        <title>Сообщения</title>
    </head>
    <body>
         <h3>Полученные сообщения</h3>
         <table border="1">
             <tr>
                 <th>Дата и время отправки</th>
                 <th>От кого</th>
                 <th>Текст</th>
             </tr>
             <c:forEach var="item" items="${sessionScope.messages}">
                 <tr>
                    <th><tags:localDateTime date="${item.timeSending}"/></th>
                    <th>${item.from.login}</th>
                    <th>${item.textMessage}</th>
                 </tr>
             </c:forEach>
         </table>

         <p><input type="button" onclick="location.href='${pageContext.request.contextPath}/mainPage';"
            value="На главную"></p>
    </body>
</html>