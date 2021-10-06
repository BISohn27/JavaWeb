<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border='1'>
		<c:forEach var="member" items="${memberlist }">
			<tr>
				<td>${member.no }</td>
				<td>${member.email }</td>
				<td>${member.name }</td>
				<td>${member.createDate }</td>
				<td><input type="button" onclick="location.href='Update.jsp'" value="수정">
				<td><input type="button" onclick="location.href='Delete.do?no=${member.no}'" value="삭제">
			</tr>
		</c:forEach>
	</table>
</body>
</html>