<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light d-flex align-items-center justify-content-center" style="height: 100vh;">

<div class="card shadow p-4" style="width: 400px;">
    <h2 class="text-center mb-4">로그인</h2>

    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    </c:if>
    <c:if test="${not empty message}">
        <div class="alert alert-success" role="alert">
            ${message}
        </div>
    </c:if>

    <form action="<c:url value='/perform_login' />" method="post">
        <div class="mb-3">
            <label for="username" class="form-label">아이디</label>
            <input type="text" class="form-control" id="username" name="username" required />
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">비밀번호</label>
            <input type="password" class="form-control" id="password" name="password" required />
        </div>
        <div class="d-grid">
            <button type="submit" class="btn btn-primary">로그인</button>
        </div>
    </form>

    <div class="text-center mt-3">
        <a href="/register" class="text-decoration-none">회원가입</a>
    </div>
</div>

</body>
</html>
