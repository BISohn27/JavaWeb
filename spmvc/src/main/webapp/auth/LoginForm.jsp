<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${contextPath }/test/login.do" method="post">
		아이디<input type="text" name="userID"><br>
		패스워드<input type="password" name="passwd"><br>
		<input type="submit" value="로그인"><input type="button" onclick='location.href="../member/MemberForm.html"' value="회원가입">
	</form>
</body>
</html>