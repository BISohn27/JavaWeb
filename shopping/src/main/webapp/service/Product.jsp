<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
<style type="text/css">
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
	article{
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
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
		<div id="imagebox">
			<img src="/shopping/product_images/${product.image}" alt="상품"/>
		</div>
		<form action="../order/addcart.order" method="post">
			<table>
				<tr><td>상품명</td><td>${product.name }</td></tr>
				<tr><td>가격</td><td>${product.price2 }</td></tr>
				<tr><td>수량</td><td><input type="text" name="quantity" /></td>
			</table>
			<input type="hidden" name="id" value="${member.id }">
			<input type="hidden" name="pseq" value="${product.pseq }">
			<input type="submit" value="장바구니">
		</form>
		<div id="productcontent">
			${product.content }
		</div>
	</article>
	</section>
</body>
</html>