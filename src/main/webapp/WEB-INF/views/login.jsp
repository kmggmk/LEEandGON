<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>

    <c:if test="${not empty error}">
        <div style="color: red;">${error}</div>
    </c:if>
    <c:if test="${not empty message}">
        <div style="color: green;">${message}</div>
    </c:if>

    <form action="<c:url value='/perform_login' />" method="post">
        <div>
            <label>Username:</label> <input type="text" name="username" />
        </div>
        <div>
            <label>Password:</label> <input type="password" name="password" />
        </div>
        <div>
            <input type="submit" value="Login" />
        </div>
    </form>
    <a href="/register">회원가입</a>
</body>
</html>
