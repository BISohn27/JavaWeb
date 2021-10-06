<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Main Page</title>
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
		height:10vh;
	}
	section{
	width: 100%;
	height: 65vh;
	text-align: center;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-grow: 1;
	}
	footer{
		height:10vh;
	}
	#loginbox{
		width: 30%;
		height: 80%;
		border-radius: 10px 10px 10px 10px;
		box-shadow: 4px 5px 11px 0px rgba(50, 50, 50, 0.67);
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.logintextbox{
		width: 60%;
		height: 5vh;
		margin: 0.5vh;
		padding-right: 11%;
		padding-left: 11%;
		border: 1px solid lightgray;
		border-radius: 10px 10px 10px 10px;
	}
	#loginicon {
		width: 83%;
		height: 5vh;
		display: inline-block;
		margin-top: 2vh;
		margin-bottom: 2vh;
		background-color: #2E2E2E;
		border: 1px solid #151515;
		border-radius: 8px 8px 8px 8px;
		color: white;
		font-weight: bolder;
	}
	#signin {
		width: 25%;
		height: 4vh;
		display: inline-block;
		background-color: #0080FF;
		border: 1px solid #0174DF;
		border-radius: 10px 10px 10px 10px;
		color: white;
		font-weight: bolder;
	}
	input#loginicon:hover{ background-color: black; }
	input#signin:hover{background-color: #0174DF; }
	</style>
</head>
<body>
		<header>
	      <jsp:include page="../include/Header.jsp" />
   		</header>
		<nav>
		</nav>
		<section>
		<c:if test="${param.status eq 'loginfail'}">
			<script>alert('아이디 또는 패스워드가 맞지 않습니다.');</script>
		</c:if>
				<div id="loginbox">
					<form action="../NonageServlet" method="post">
						<input class="logintextbox" type="text" name="id" placeholder="아이디를 입력하세요.">
						<input class="logintextbox" type="password" name="pwd" placeholder="패스워드를 입력하세요."><br>
						<input type="hidden" name="command" value="login">
						<input id="loginicon" type="submit" value="로그인"><br>
						<hr>
						<br>
						<input id="signin" type="button" onclick="location.href='Join.jsp'" value="회원가입">
					</form>
				</div>
			</section>
		<footer>
		</footer>
</body>
</html>