<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action='update.do' method='post'>
		번호: <input type='text' name='no' value='${member.getNo() }' readonly>
		이메일: <input type='text' name='email' value='${member.getEmail() }'>
		이름: <input type='text' name='name' value='${member.getName() }'>
		패스워드: <input type='password' name='pwd'>
	<input type='submit' value='회원정보수정'><input type='reset' value='전체내용삭제'> 
	</form>
</body>
</html>