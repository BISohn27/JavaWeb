<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.ProductVO, java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Heels</title>
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
		width:100%;
		height:150vh;
	}
	aside{
		width:15%;
		height:100%;
	}
	article{
		width:85%;
		height:100%
		display: flex;
		flex-direction:column;
		justify-content: space-between;
		
	}
	.wrap{
		width: 100%;
		height: 33%;
		display: flex;
		justify-content: space-evenly;
	}
	.wrapbox{
		width:20%;
		height:90%;
		display: flex;
		flex-direction: column;
	}
	.imagebox{
		width:100%;
		height:80%;
		background-color: white;
		margin:0px 0px 2vh 0px;
		box-shadow: 4px 5px 11px 0px rgba(50, 50, 50, 0.67);
		border-radius: 10px 10px 10px 10px;
		display:flex;
		justify-content: center;
		align-items: center;
	}
	
	.textbox{
		text-align:center;
	}
	a{
		text-decoration: none;
		color:black;
	}
	a:hover{
		color: gray;
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
		<aside>
		</aside>
		<article>
			<div class="wrap">
				<c:choose>
						<c:when test="${not empty heelslist[0].image }">
							<div class="wrapbox">
								<div class="imagebox"><img src="/shopping/product_images/${ heelslist[0].image }" alt="heels" width="90%" height="90%"></div>
								<div class="textbox"><a href="product.product?pseq=${heelslist[0].pseq }">${ heelslist[0].name }</a></div>
								<div class="textbox">${ heelslist[0].price2 }</div>
							</div>
						</c:when>
				<c:otherwise>
						<div class="wrapbox">
							<div class="imagebox"></div>
							<div class="textbox"></div>
							<div class="textbox"></div>
						</div>
				</c:otherwise>
				</c:choose>
				<c:choose>
						<c:when test="${not empty heelslist[1].image }">
							<div class="wrapbox">
								<div class="imagebox"><img src="/shopping/product_images/${ heelslist[1].image }" alt="heels" width="90%" height="90%"></div>
								<div class="textbox"><a href="product.product?pseq=${heelslist[1].pseq }">${ heelslist[1].name }</a></div>
								<div class="textbox">${ heelslist[1].price2 }</div>
							</div>
						</c:when>
				<c:otherwise>
						<div class="wrapbox">
							<div class="imagebox"></div>
							<div class="textbox"></div>
							<div class="textbox"></div>
						</div>
				</c:otherwise>
				</c:choose>
				<c:choose>
						<c:when test="${not empty heelslist[2].image }">
							<div class="wrapbox">
								<div class="imagebox"><img src="/shopping/product_images/${ heelslist[2].image }" alt="heels" width="90%" height="90%"></div>
								<div class="textbox"><a href="product.product?pseq=${heelslist[2].pseq }">${ heelslist[2].name }</a></div>
								<div class="textbox">${ heelslist[2].price2 }</div>
							</div>
						</c:when>
				<c:otherwise>
						<div class="wrapbox">
							<div class="imagebox"></div>
							<div class="textbox"></div>
							<div class="textbox"></div>
						</div>
				</c:otherwise>
				</c:choose>
				</div>
			<div class="wrap">
				<c:choose>
						<c:when test="${not empty heelslist[3].image }">
							<div class="wrap box">
								<div class="imagebox"><img src="/shopping/product_images/${ heelslist[3].image }" alt="heels" width="90%" height="90%"></div>
								<div class="textbox"><a href="product.product?pseq=${heelslist[3].pseq }">${ heelslist[3].name }</a></div>
								<div class="textbox">${ heelslist[3].price2 }</div>
							</div>
						</c:when>
				<c:otherwise>
						<div class="wrapbox">
							<div class="imagebox"></div>
							<div class="textbox"></div>
							<div class="textbox"></div>
						</div>
				</c:otherwise>
				</c:choose>
				<c:choose>
						<c:when test="${not empty heelslist[4].image }">
							<div class="wrapbox">
								<div class="imagebox"><img src="/shopping/product_images/${ heelslist[4].image }" alt="heels" width="90%" height="90%"></div>
								<div class="textbox"><a href="product.product?pseq=${heelslist[4].pseq }">${ heelslist[4].name }</a></div>
								<div class="textbox">${ heelslist[4].price2 }</div>
							</div>
						</c:when>
				<c:otherwise>
						<div class="wrapbox">
							<div class="imagebox"></div>
							<div class="textbox"></div>
							<div class="textbox"></div>
						</div>
				</c:otherwise>
				</c:choose>
				<c:choose>
						<c:when test="${not empty heelslist[5].image }">
							<div class="wrapbox">
								<div class="imagebox"><img src="/shopping/product_images/${ heelslist[5].image }" alt="heels" width="90%" height="90%"></div>
								<div class="textbox"><a href="product.product?pseq=${slipperslist[5].pseq }">${ heelslist[5].name }</a></div>
								<div class="textbox">${ heelslist[5].price2 }</div>
							</div>
						</c:when>
				<c:otherwise>
						<div class="wrapbox">
							<div class="imagebox"></div>
							<div class="textbox"></div>
							<div class="textbox"></div>
						</div>
				</c:otherwise>
				</c:choose>
				</div>
			<div class="wrap">
				<c:choose>
						<c:when test="${not empty heelslist[6].image }">
							<div class="wrapbox">
								<div class="imagebox"><img src="/shopping/product_images/${ heelslist[6].image }" alt="heels" width="90%" height="90%"></div>
								<div class="textbox"><a href="product.product?pseq=${heelslist[6].pseq }">${ heelslist[6].name }</a></div>
								<div class="textbox">${ heelslist[6].price2 }</div>
							</div>
						</c:when>
				<c:otherwise>
						<div class="wrapbox">
							<div class="imagebox"></div>
							<div class="textbox"></div>
							<div class="textbox"></div>
						</div>
				</c:otherwise>
				</c:choose>
				<c:choose>
						<c:when test="${not empty heelslist[7].image }">
							<div class="wrapbox">
								<div class="imagebox"><img src="/shopping/product_images/${ heelslist[7].image }" alt="heels" width="90%" height="90%"></div>
								<div class="textbox"><a href="product.product?pseq=${heelslist[7].pseq }">${ heelslist[7].name }</a></div>
								<div class="textbox">${ heelslist[7].price2 }</div>
							</div>
						</c:when>
				<c:otherwise>
						<div class="wrapbox">
							<div class="imagebox"></div>
							<div class="textbox"></div>
							<div class="textbox"></div>
						</div>
				</c:otherwise>
				</c:choose>
				<c:choose>
						<c:when test="${not empty heelslist[8].image }">
							<div class="wrapbox">
								<div class="imagebox"><img src="/shopping/product_images/${ heelslist[8].image }" alt="heels" width="90%" height="90%"></div>
								<div class="textbox"><a href="product.product?pseq=${heelslist[8].pseq }">${ heelslist[8].name }</a></div>
								<div class="textbox">${ heelslist[8].price2 }</div>
							</div>
						</c:when>
				<c:otherwise>
						<div class="wrapbox">
							<div class="imagebox"></div>
							<div class="textbox"></div>
							<div class="textbox"></div>
						</div>
				</c:otherwise>
				</c:choose>
			</div>
		</article>
	</section>
	<footer>
	</footer>
</body>
</html>