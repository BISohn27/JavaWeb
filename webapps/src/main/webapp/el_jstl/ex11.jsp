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
<h2>c:url 태그</h2>
<c:url var="var" value="http://daum.net">
	<c:param name="p1" value="value1"/>
</c:url>
<a href="${var}">이동</a>
<h2>c:redirect 태그</h2>
<%-- <c:redirect url="http://www.daum.net"/> --%>
</body>
</html>