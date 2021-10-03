<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
	<h2>c:out 태그</h2>
	<c:out value="안녕하세요!"/><br>
	<c:out value="${null}">반갑습니다.</c:out><br>
	<c:out value="안녕하세요">반갑습니다.</c:out><br>
	<c:out value="${null}"/><br>
</body>
</html>