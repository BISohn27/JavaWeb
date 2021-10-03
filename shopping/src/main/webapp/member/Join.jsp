<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member Form</title>
<link rel="shortcut icon" href="#">
<style>
	header{
		width:100%;
		height:30%;
		border-bottom: 1px solid lightgray;
		display: flex;
		justify-content: space-between;
		align-items:center;
	}
	section {
		width:100%;
		height: 70vh;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}
	footer{
		width: 100%;
	}
	table {
		width: 100%;
		height: 100%;
		padding-left: 10%;
	}
	.box{
		height: 4vh;
		width: 30vw;
	}
	.email{
		height: 4vh;
		width: 14vw;
	}
	.box, .email{
		border: 1px solid lightgray;
		border-radius: 8px;
	}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="/shopping/member/member.js">
</script>
</head>
<body>
	<header>
		<jsp:include page="../include/Header.jsp" />
	</header>
	<section>
		<h2>Join Us</h2>
		<form name="formm">	
			<table>
				<tr><td><input id="id" class="box" type="text" name="id" placeholder="아이디를 입력하세요."><input id="checkbutton" type="button" onclick="idCheck()" value="중복검사"></td></tr>
				<tr><td><input class="box" type="password" name="pwd" placeholder="비밀번호를 입력하세요."></td></tr>
				<tr><td><input class="box" type ="text" name="name" placeholder="이름을 입력하세요."></td></tr>
				<tr><td><input class="email" type= "text" name="emailid" size="20" maxlength="20" placeholder="이메일 아이디를 입력하세요.">@<input class="email" type="text" name="emailaddress" size="20" maxlength="20" placeholder="이메일 주소를 입력하세요."></td></tr>
				<tr><td><input class="box" type= "text" name="zipcode"><input type="button" onclick="searchPost()" value="우편번호검색"></td></tr>
				<tr><td><input class="box" type= "text" name="address" placeholder="주소를 입력하세요."></td></tr>
				<tr><td><input class="box" type= "text" name="phone" placeholder="전화번호를 입력하세요."></td></tr>
				<tr><td><input type="button" value="가입하기" onclick='goSave()'/><input type="reset" value="다시입력"></td></tr>
			</table>
		</form>
	</section>
	<footer>
	</footer>
</body>
</html>