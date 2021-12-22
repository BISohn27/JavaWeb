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
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
		function sendOrder(){
			const id = $('input[name=id]').val();
			let arr = [];
			let cseqArr = [];
			
			$("#cartTable tr").each((index,item)=>{
				
				if($(item).find("td").length !== 0){
					const pseq = $(item).find("td").eq(0).text();
					const pname = $(item).find("td").eq(1).text();
					const quantity = $(item).find("td").eq(2).text();
					const cseq =$("#"+pseq).val();
					
					let items = {
						pseq: pseq,
						pname: pname,
						quantity: quantity,
					};
					arr.push(items);
					cseqArr.push(cseq);
				}
			});
			
			console.log(arr);
			$.ajax({
				dataType:"text",
				type:"POST",
				async:true,
				data: {
					data:JSON.stringify(arr),
					id: id,
					cseq: JSON.stringify(cseqArr),
				},
				url: 'addorder.order',
				success:function(data){
					if(confirm("주문이 완료되었습니다. 주문내역으로 이동하시겠습니까?")){
						location.href="/shopping/order/order.order?id="+id;
					} else{
						location.href="/shopping/order/cart.order?id="+id;
					}
				},
				error:function(data){
					console.log(data);
				},
			});
		}
		
	</script>
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
	<form method="post">
	<table id="cartTable">
		<tr><th>상품코드</th><th>상품명</th><th>수량</th><th>상품가격</th><th>전체 가격</th></tr>
	<c:choose>
		<c:when test="${not empty cart}">
			<c:forEach var="item" items="${cart }">
				<tr>
					<td>${item.pseq }</td>
					<td>${item.pname }</td>
					<td>${item.quantity }</td>
					<td>${item.price2 }</td>
					<td>${item.price2 * item.quantity }</td>
					<td>
						<input type="hidden" name="id" value="${member.id }">
						<input type="hidden" name="cseq" id="${item.pseq}" value="${item.cseq }">
						<input type="submit" value="삭제" onclick="javascript: form.action='deletecart.order';">
					</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr><td rowspan="4" colspan="5">장바구니가 비어있습니다.</td>
		</c:otherwise>
	</c:choose>
	</table>
	</form>
	<input type="button" value="주문" onClick="sendOrder()">
</section>
<footer>
</footer>
</body>
</html>