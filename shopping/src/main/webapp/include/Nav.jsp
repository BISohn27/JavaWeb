<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>nav</title>
<style>
	ul.navul{
		width: 50%;
		padding-top: 20px;
		list-style: none;
		display: flex;
		justify-content: space-between;
	}
	a.navanchor{
		font-size: x-large;
		font-weight: bold;
		text-decoration: none;
		color: black;
	}
	a.navanchor:hover{
		color: gray;
	}
</style>
</head>
<body>
	<ul class="navul">
		<li><a class="navanchor" href="/service/heels.product">Heels</a></li>
		<li><a class="navanchor" href="/service/boots.product">Boots</a></li>
		<li><a class="navanchor" href="/service/sandals.product">Sandals</a></li>
		<li><a class="navanchor" href="/service/sneakers.product">Sneakers</a></li>
		<li><a class="navanchor" href="/service/onsale.product">On sale</a></li>
	</ul>
</body>
</html>