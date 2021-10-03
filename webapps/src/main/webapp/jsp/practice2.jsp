<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#header {
	height: 100px;
	margin: 0 auto;
	background-color: lightblue;
	display: flex;
	text-align: right;
}

#nav {
	height: 100px;
	margin: 0 auto;
	background-color: red;
}

#aside {
	width: 300px;
	height: 500px;
	margin: 0 auto;
	float: left;
	background-color: lightgreen;
	display: flex;
	align-items: center;
	text-align: center;
}

#main {
	height: 500px;
	margin: 0 auto;
	float: left;
	border
}

#footer {
	height: 100px;
	margin: 0 auto;
	background-color: gray;
}

#wrap {
	margin: 0 auto;
	height: 500px;
	overflow: hidden;
}
</style>
</head>
<body>
	<div id="header">
		<jsp:include page="../include/Header.jsp" />
	</div>
	<div id="nav">nav</div>
	<div id="wrap">
	<div id="aside">
	</div>
	<div id="main">main</div>
	</div>
	<div id="footer">footer</div>
</body>
</html>