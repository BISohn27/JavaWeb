<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
		background-color:#F5F5F5
	}
	header{
		height: 10vh;
		border-bottom: 1px solid lightgray;
        display: flex;
        justify-content: space-between;
	    align-items: center;
	}
	nav{
		padding-bottom: 5vh;
		display: flex;
		justify-content: center;
	}
	section{
		height:70vh;
	}
</style>
</head>
<body>
	<header>
		<jsp:include page="../include/Header.jsp" />
	</header>
	<nav>
		<jsp:include page="../include/Nav.jsp" />
	</nav>
<section>
	<article>
		<table>
			<tr><th colspan="4">${board.subject }</th></tr>
			<tr><td colspan="4">${board.content }</td></tr>
			<tr><td colspan="2"></td> <td>${board.id }</td><td>${board.indate }</td></tr>
		</table>
		<table>
			<tr><td>${board.req }</td></tr>
		</table>
	</article>
	<article>
	</article>
</section>
</body>
</html>