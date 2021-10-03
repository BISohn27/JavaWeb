<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.UserInfo, java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<%-- <%
	ArrayList<UserInfo> list =(ArrayList<UserInfo>)request.getAttribute("list");
%> --%>
<body>
	<c:forEach var="user" items="${list}">
	<table border="1">
		<tr>
		<th>ID</th><th>Password</th><th>Name</th>
		</tr>
		<%-- <% for(int i=0; i<list.size(); i++) { %> --%>
		<tr>
			<td>${user.id}</td>
			<td>${user.pw }</td>
			<td>${user.name }</td>
			<%-- <td><%= list.get(i).getId() %> </td>
			<td><%= list.get(i).getPw() %> </td>
			<td><%= list.get(i).getName() %> </td> --%>
		</tr>
		<%-- <% } %> --%>
	</table>
	</c:forEach>
</body>
</html>