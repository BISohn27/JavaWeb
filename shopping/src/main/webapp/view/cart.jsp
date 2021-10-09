<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
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
		display:flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	table {
		border-style: hidden;
		border-collapse: collapse;
		border-radius: 10px;
		box-shadow: 0 0 0 1px #000;
	}
	th,td{
		border:1px solid gray;
		text-align:center;
	}
	th{
		background-color: lightgray;
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
	<h1>${member.name }님의 장바구니</h1>
	<form action="deletecart.order" method="post">
	<table>
		<tr><th>상품명</th><th>수량</th><th>상품가격</th><th>전체 가격</th></tr>
	<c:choose>
		<c:when test="${not empty cart}">
			<c:forEach var="item" items="${cart }">
				<tr>
					<td>${item.pname }</td>
					<td>${item.quantity }</td>
					<td>${item.price2 }</td>
					<td>${item.price2 * item.quantity }</td>
					<td>
						<input type="hidden" name="id" value="${member.id }">
						<input type="hidden" name="cseq" value="${item.cseq }">
						<input type="submit" value="삭제">
					</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr><td rowspan="4" colspan="4">장바구니가 비어있습니다.</td>
		</c:otherwise>
	</c:choose>
	</table>
	</form>
</section>
<footer>
</footer>
</body>
</html>