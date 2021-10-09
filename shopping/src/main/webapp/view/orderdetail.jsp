<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Order</title>
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
		width: 100%;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	table{
		width:100%;
		border-collapse: collapse;
	}
	th,td{
		border: 1px solid gray;
		text-align: center;
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
	<c:choose>
		<c:when test="${not empty orderdetail}">
		<form action="../order/orderdetail.order" method="post">
		<h1>주문 상세내역</h1>
		<table>
			<tr><th>주문번호</th><th>주문날짜</th><th>주문자명</th><th>우편번호</th><th>주소</th><th>전화번호</th></tr>
			<tr>
				<td>${orderdetail[0].oseq }</td>
				<td>${orderdetail[0].indate }</td>
				<td>${orderdetail[0].name }</td>
				<td>${orderdetail[0].zipcode }</td>
				<td>${orderdetail[0].address }</td>
				<td>${orderdetail[0].phone }</td>
			</tr>
		</table>
		<table>
			<tr><th>상품명</th><th>수량</th><th>상품금액</th><th>전체금액</th></tr>
			<c:set var="total" value="0"/>
			<c:forEach var="item" items="${orderdetail }">
				<tr>
					<td>${item.pname }</td>
					<td>${item.quantity }</td>
					<td>${item.price2 }</td>
					<td>${item.price2 * item.quantity }</td>
				</tr>
				<c:set var="total" value="${total + item.price2 * item.quantity }"/>
			</c:forEach>
				<tr>
					<td colspan="3" >총 금액</td>
					<td>${total }</td></tr>
		</table>
		</form>
		</c:when>
		<c:otherwise>
			<tr><td rowspan="4" colspan="4">상세 주문을 조회할 수 없습니다.</td>
		</c:otherwise>
	</c:choose>
</section>
<footer>
</footer>
</body>
</html>