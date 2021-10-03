<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!
		int a;
		int b;
	%>
	<%
		a = 10;
		b = 400;
		if(b/a >10){
	%>
		<p style="color: blue;">
		<%-- 문자열을 출력하는 방법 3가지 --%>
		양의 값(첫번째) <br>            <%-- 동적인 페이지 형성이 안되는 출력 방법 --%>
		<%= " 양의 값(두번째) " %> <br> <%-- 출력태그 --%>
		<% out.println("다시 양의 값(세번째)"); %>
	<%
		}else {
	%>
		음의 값
	<% 
		}
	%>
</body>
</html>