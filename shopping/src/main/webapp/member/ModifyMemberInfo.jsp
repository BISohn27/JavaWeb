<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function searchPost(){
		window.open('Zipcode.jsp','zip','width=800,height=600');
	}
	
	function inputAddress(address,zipcode){
		formp.zipcode.value = zipcode;
		formp.address.value = address; 
	}
</script>
<style type="text/css">
	body{
		height: 100vh;
		background-color:#F5F5F5;
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
		height:50%;
	}
	form{
		width:100%;
		height:100%;
		display: flex;
		flex-direction:column;
		justify-content:center;
		align-items:center;
	}
	table{
		margin: 0px auto;
		width:100%;
		height:100%;
		border-collapse:seperate;
		border:none;
		border-radius: 10px 10px 10px 10px;
	}
	th{
		text-align: center;
	}
	tr{
		text-align: center;
		background-color: #FBFCFC;
		border-radius: 10px 10px 10px 10px;
	}
	input[type="text"]{
		width: 80%;
		height: 90%;
		margin: 0px auto;
		padding-right: 10%;
		padding-left: 10%;
		border: 1px solid lightgray;
		border-radius: 10px 10px 10px 10px;
	}
	input[type="submit"], input[type="reset"],#delete{
		width: 33%;
		height: 5vh;
		display: inline-block;
		background-color: #2E2E2E;
		border: 1px solid #151515;
		border-radius: 8px 8px 8px 8px;
		color: white;
		font-weight: bolder;
	}
	#tablebox{
		width:40%;
		height:50%;
		background-color: white;
		margin:0px 0px 2vh 0px;
		box-shadow: 4px 5px 11px 0px rgba(50, 50, 50, 0.67);
		border-radius: 10px 10px 10px 10px;

	}
	#buttonbox{
		width:40%;
	}
	input[type="submit"]:hover, input[type="reset"]:hover, #delete:hover{ 
		background-color: black; 
	}
	#zipsearch{
		width:30%;
		height:100%;
		display: inline-block;
		background-color: #2E2E2E;
		border: 1px solid #151515;
		border-radius: 5px 5px 5px 5px;
		font-size:small;
		color: white;
	}
	#zipsearch:hover {
		background-color: black; 
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
		<form action="../NonageServlet" method="post" name="formp">
		<div id="tablebox">
			<table>
					<tr><th>아이디</th><td><input type="text" name="id" value="${member.id }" readonly/></td></tr>
					<tr><th>이름</th><td><input type="text" name="name" value="${member.name }"readonly/></td></tr>
					<tr><th>이메일</th><td><input type="text" name="email" value="${member.email }"></td></tr>
					<tr><th>우편번호</th><td><input style="width:40%;float:left" type="text" name="zipcode" value="${member.zipcode }"><input  style="float:right" id="zipsearch" type="button" value="우편번호검색" onclick="searchPost()"></tr>
					<tr><th>주소</th><td><input type="text" name="address" value="${member.address }"></td></tr>
					<tr><th>전화번호</th><td><input type="text" name="phone" value="${member.phone }"></td></tr>
			</table>
		</div>
		<div id="buttonbox">
			<input type="hidden" name="command" value="modify">
			<input type="submit" value="회원정보수정"><input type="reset" value="전체내용삭제"><input id = "delete" type="button" value="회원탈퇴" onclick="location.href='../NonageServlet?command=delete&id=${member.id }'"/>
		</div>
		</form>
	</section>
	<footer>
	</footer>
</body>
</html>