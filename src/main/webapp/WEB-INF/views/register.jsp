<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="EUC-KR">
    <title>회원가입</title>
</head>
<body>

<h2>회원가입</h2>
<form action="/register" method="post">
    <label for="username">아이디:</label>
    <input type="text" id="username" name="username" required><br><br>

    <label for="password">비밀번호:</label>
    <input type="password" id="password" name="password" required><br><br>

    <label for="email">이메일:</label>
    <input type="email" id="email" name="email" required><br><br>

    <label for="name">이름:</label>
    <input type="text" id="name" name="name" required><br><br>
    
    <label for="authority">Authority:</label>
    <select id="authority" name="authority" required>
        <option value="ROLE_USER">User</option>
        <option value="ROLE_ADMIN">Admin</option>
    </select><br><br>

    <button type="submit">가입하기</button>
</form>

</body>
</html>
