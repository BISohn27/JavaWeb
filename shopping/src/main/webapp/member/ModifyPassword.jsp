<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modify Password Page</title>
	<script>
		function submitInfo() {
			let pwd = document.formp.pwd.value;
			let pwda = document.formp.pwda.value;
			console.log(pwda);
			console.log(pwd);
			debugger;
			if(pwd == '' || pwd.trim().length == 0){
				alert('패스워드를 입력해주세요.');
			} else if(pwda == '' || pwda.trim().length == 0){
				alert('확인용 패스워드를 입력해주세요.');
			} else if(pwda != pwd) {
				alert('패스워드가 일치하지 않습니다.');
			} else {
				document.formp.submit();
			}
	}
	</script>
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
	#passwordbox{
		width: 30%;
		height: 80%;
		border-radius: 10px 10px 10px 10px;
		box-shadow: 4px 5px 11px 0px rgba(50, 50, 50, 0.67);
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.passwordbox{
		width: 60%;
		height: 5vh;
		margin: 0.5vh;
		padding-right: 11%;
		padding-left: 11%;
		border: 1px solid lightgray;
		border-radius: 10px 10px 10px 10px;
	}
	#submitbutton {
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
	#backward {
		width: 25%;
		height: 4vh;
		display: inline-block;
		background-color: #0080FF;
		border: 1px solid #0174DF;
		border-radius: 10px 10px 10px 10px;
		color: white;
		font-weight: bolder;
	}
	input#backward:hover{ background-color: #0174DF;}
	input#submitbutton:hover{background-color: black; }
	</style>
</head>
<body>
		<header>
	      <jsp:include page="../include/Header.jsp" />
   		</header>
		<nav>
		</nav>
		<section>
				<div id="password">
					<form action="../NonageServlet" method="post" name="formp">
						<input class="passwordbox" type="password" name="pwd" placeholder="패스워드를 입력하세요.">
						<input class="passwordbox" type="password" name="pwda" placeholder="다시 한번 패스워드를 입력하세요."><br>
						<input type="hidden" name="id" value="${member.id }">
						<input type="hidden" name="command" value="password">
						<input id="submitbutton" type="button" onclick="submitInfo()" value="비밀번호 수정"><br>
						<input id="backward" type="button" onclick="location.href='modifyform.jsp'" value="이전화면">
					</form>
				</div>
			</section>
		<footer>
		</footer>
</body>
</html>