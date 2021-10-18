<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="ckeditor/ckeditor.js"></script>
<style>
body {
	background-color: #F5F5F5
}

header {
	height: 10vh;
	border-bottom: 1px solid lightgray;
	display: flex;
	justify-content: space-between;
	align-items: center;
}

nav {
	padding-bottom: 5vh;
	display: flex;
	justify-content: center;
}

section{
	display:flex;
	justify-content: center;
}

form{
	width: 60%;
}

#writerbox{
	width: 100%;
}
#title{
	width: 99%;
	height: 3vh;
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
		<form action="../customerservice/write.customerservice" method="post">
			<h3>글제목</h3>
			<input id="title" type="text" name="title">
			<h3>글내용</h3>
			<div id="writerbox">
				<textarea name="content" id="description" rows="40" cols="80">
				</textarea>
				<script>
					CKEDITOR.replace("description");
				</script>
			</div>
			<input type="hidden" name="id" value="${member.id }">
			<input type="submit" value="작성">
		</form>
	</section>
</body>
</html>