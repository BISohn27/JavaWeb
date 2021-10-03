<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>fmt:parseDate 태그</h2>
	<code>
		&lt;fmt:parseDate var="date1" value="2021-09-03" pattern="yyyy-MM-dd"/>
	</code>
	<fmt:parseDate var="date1" value="2021-09-03" pattern="yyyy-MM-dd"/>
	<h3>fmt:formatDate 태그</h3>
	<fmt:formatDate value="${date1 }" pattern="MM/dd/yy"/>
</body>
</html>