<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% pageContext.setAttribute("nameList", new String[]{"홍길동","임꺽정", "일지매"}); %>
<h2>반복문-배열</h2>
<ul>
	<c:forEach var="name" items="${nameList}">
		<li>${name}</li>
	</c:forEach>
</ul>
<h2>반복문 - 배열의 시작 인덱스와 종료 인덱스 지정</h2>
<% pageContext.setAttribute("nameList2", new String[]{"홍길동","임꺽정", "일지매","주먹대장"}); %>
<ul>
	<c:forEach var="name" items="${nameList2}" begin="2" end="3">
		<li>${name }</li>
	</c:forEach>
</ul>
<h2>반복문 - ArrayList</h2>
<%
	ArrayList<String> nameList3 = new ArrayList<String>();
	nameList3.add("홍길동");
	nameList3.add("임꺽정");
	nameList3.add("일지매");
	pageContext.setAttribute("nameList3",nameList3);
%>
<ul>
	<c:forEach var="name" items="${nameList3 }">
		<li>${name }</li>
	</c:forEach>
	</ul>
<h2>반복문-특정 횟수만큼 반복</h2>
<c:forEach var="no" begin="1" end="9">
	<li><a href="ex${no}.jsp">예제${no}</a></li>
</c:forEach>
<h2>반복문 - 콤마로 구분된 문자열</h2>
<% pageContext.setAttribute("nameList4", "홍길동,임꺽정,일지매,주먹대장,똘이장군"); %>
<ul>
	<c:forEach var="name" items="${nameList4 }">
		<li>${name}</li>
	</c:forEach>
</ul>
</body>
</html>