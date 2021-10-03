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
	<h2>c:if 태그</h2>
	<c:if test="${10>20}" var="result1">
	1) 10은 20보다 크다.<br>
	</c:if>
	${result1}
	<c:if test="${10<20}" var="result2">
	${result2}
	</c:if>
</body>
</html>