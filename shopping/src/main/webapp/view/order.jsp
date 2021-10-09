<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
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
		text-align: center;
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
	<h1>${member.name }님의 주문내역</h1>
	<table>
		<tr><th>주문번호</th><th>주문날짜</th><th>총 주문건수</th><th>총 가격</th>
		<c:choose>
		<c:when test="${not empty order}">
		<form action="../order/orderdetail.order" method="post">
			<c:forEach var="item" items="${order }">
				<tr>
					<td>${item.oseq }</td>
					<td>${item.indate }</td>
					<td>${item.cnt}</td>
					<td>${item.sum }</td>				
					<td><input type="hidden" name="id" value="${member.id }"/><input type="hidden" name="oseq" value="${item.oseq }"/><input type="submit" value="상세정보"/></td>
				</tr>
			</c:forEach>
			</form>
		</c:when>
		<c:otherwise>
			<tr><td rowspan="4" colspan="4">주문내역이 없습니다.</td></tr>
		</c:otherwise>
	</c:choose>
	</table>
</section>
<footer>
</footer>
</body>
</html>