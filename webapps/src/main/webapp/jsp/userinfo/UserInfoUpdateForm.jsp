<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.example.sba.domain.UserInfo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- <%
	UserInfo userinfo = (UserInfo)request.getAttribute("userinfo");
%> --%>
<body>
<%-- 	<jsp:include page="/include/Header.jsp"/> --%>
	<form action = "/webapps/UserInfoUpdateServlet" method="post">
		<table border="1">
			<tr>
				<th>Id</th><td><input type="text" name="id" value="${userinfo.id }" readonly></td>
			</tr>
			<tr>
				<th>PW</th><td><input type="text" name="pw" value="${userinfo.pw }"></td>
			</tr>
			<tr>
				<th>Name</th><td><input type="text" name="name" value="${userinfo.name }"></td>
			</tr>
			<tr>
		</table>
		<input type="submit" value="수정">
		<input type="button" value="삭제" onclick="location.href='/webapps/UserInfoDeleteServlet?id=${userinfo.id }'">
		<input type="button" value="취소" onclick="location.href='/webapps/jsp/practice2.jsp'">
	</form>
</body>
</html>