<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.ProductVO, java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Mall</title>
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
nav {
	display: flex;
	justify-content: center;
}
section{
	width:100%
}
article{
	width: 100%;
	background-color:#F5F5F5;
	display: flex;
	justify-content: space-evenly;
}
footer{
	height: 15vh;
}
.newitem{
	width:20%;
	height: 40vh;
	background-color: white;
	margin-top: 5vh;
	margin-bottom: 5vh;
	box-shadow: 4px 5px 11px 0px rgba(50, 50, 50, 0.67);
	border-radius: 10px 10px 10px 10px;
	display:flex;
	justify-content: center;
	align-items: center;
}
.bestitem{
	width:23%;
	height: 60vh;
	margin-top: 5vh;
	margin-bottom: 5vh;
	box-shadow: 4px 5px 11px 0px rgba(50, 50, 50, 0.67);
	border-radius: 10px 10px 10px 10px;
	display:flex;
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
			<div class="newitem">
				<img src="/shopping/product_images/${newProductList[0].image}" alt="New1" width="90%">
			</div>
			<div class="newitem">
				<img src="/shopping/product_images/${newProductList[1].image}" alt="New2" width="90%">
			</div>
			<div class="newitem">
				<img src="/shopping/product_images/${newProductList[2].image}" alt="New3" width="90%">
			</div>
			<div class="newitem">
				<img src="/shopping/product_images/${newProductList[3].image}" alt="New4" width="90%">
			</div>
		</article>
		<article>
			<div class="bestitem">
				<img src="/shopping/product_images/${bestProductList[0].image}" alt="best1" width="90%">
			</div>
			<div class="bestitem">
				<img src="/shopping/product_images/${bestProductList[1].image}" alt="best2" width="90%">
			</div>
			<div class="bestitem">
				<img src="/shopping/product_images/${bestProductList[2].image}" alt="best3" width="90%">
			</div>
			<div class="bestitem">
				<img src="/shopping/product_images/${bestProductList[3].image}" alt="best4" width="90%">
			</div>
		</article>
	</section>
	<footer>
	</footer>
</body>
</html>