<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.MemberVO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<style>
ul.headerul{
	width: 40%;
	padding: 0px 5vw 0px 0px;
	margin: 0px;
	color:black;
	list-style: none;
	display: flex;
	justify-content: space-between;
}
li{
	width:15%
}
a.headeranchor{
	color: black;
	font-size: 15px;
	text-decoration: none;
}
#headerleft{
	padding-left:50px;
	padding-top:4px;
	padding-bottom: 8px;
}
#cop{
	font-size: medium;
	font-weight: bolder;
}
/* a.headeranchor:hover{
	text-decoration: underline;
} */
#member {
	font-size:medium;
}
#headericon {
	color: black;
	text-decoration: none;
}
#cart, #logout, #order, #login, #mypage, #qna{
	opacity:0;
	font-size:10px;
}
#acart:hover #cart{
	color: gray;
	opacity:1;
}
#alogin:hover #login{
	color: gray;
	opacity:1;
}
#alogout:hover #logout{
	color: gray;
	opacity:1;
}
#aorder:hover #order{
	color: gray;
	opacity:1;
}
#aqna:hover #qna{
	color: gray;
	opacity:1;
}
#amypage:hover #mypage{
	color: gray;
	opacity:1;
}
</style>
</head>
<body>
<div id="headerleft">
	<a id="headericon" href="../service/index.product"><i class="fas fa-atom fa-2x"></i></a>
</div>
	<c:choose>
	<c:when test="${not empty member}">
	<ul class="headerul">
		<li><a id="alogout" class ="headeranchor" href="/shopping/NonageServlet?command=logout"><i class="fas fa-user"></i><span id ='logout'> ${member.getId()} 로그아웃</span></a></li>
		<li><a id ="acart" class ="headeranchor" href="../order/cart.order?id=${member.id }"><i class="fas fa-shopping-bag"></i><span id='cart' class="icontext">Cart</span></a></li>
		<li><a id ="aorder" class ="headeranchor" href="../order/order.order?id=${member.id }"><i class="fas fa-receipt"></i ><span id='order' class="icontext">Order</span></a></li>
		<li><a id ="amypage" class ="headeranchor" href="../member/modifyform.jsp"><i class="fas fa-pen-fancy"></i><span id='mypage' class="icontext">MyPage</span></a></li>
		<li><a id ="aqna" class ="headeranchor" href="#"><i class="fas fa-user-friends"></i><span id='qna' class="icontext">QnA</span></a></li>
	</ul>
	</c:when>
	<c:otherwise>
	<ul class="headerul">
		<li><a id ="alogin" class ="headeranchor" href="/shopping/member/Login.jsp"><i class="fas fa-user"></i><span id='login' class="icontext">Login</span></a></li>
		<li><a id ="acart" class ="headeranchor" href="#"><i class="fas fa-shopping-bag"></i><span id='cart' class="icontext">Cart</span></a></li>
		<li><a id ="aorder" class ="headeranchor" href="#"><i class="fas fa-receipt"></i ><span id='order' class="icontext">Order</span></a></li>
		<li><a id ="amypage" class ="headeranchor" href="/shopping/member/Login.jsp"><i class="fas fa-pen-fancy"></i><span id='mypage' class="icontext">MyPage</span></a></li>
		<li><a id ="aqna" class ="headeranchor" href="#"><i class="fas fa-user-friends"></i><span id='qna' class="icontext">QnA</span></a></li>
	</ul>
	</c:otherwise>
	</c:choose>
</body>
</html>