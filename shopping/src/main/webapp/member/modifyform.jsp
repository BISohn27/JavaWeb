<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Form</title>
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
		display: flex;
		flex-direction:column;
		justify-content:center;
		align-items:center;
	}
	table{
		margin: 0px 0px 3px 0px;
		width:40%;
		height:50%;
		border-collapse:seperate;
		border:none;
		border-radius: 10px 10px 10px 10px;
		background-color: white;
		box-shadow: 4px 5px 11px 0px rgba(50, 50, 50, 0.67);
	}
	th{
		text-align: center;
		
	}
	td{
		text-align: center;
		background-color: #FBFCFC;
		width: 80%;
		height: 50%;
		margin: 0px auto;
		padding-right: 10%;
		padding-left: 10%;
		border: 1px solid lightgray;
		border-radius: 10px 10px 10px 10px;
	}
	input[type="button"]{
		width: 50%;
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
	input[type="button"]:hover{ background-color: black; }
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
			<table>
					<tr><th>아이디</th><td>${member.id }</td></tr>
					<tr><th>이름</th><td>${member.name }</td></tr>
					<tr><th>이메일</th><td>${member.email }</td></tr>
					<tr><th>우편번호</th><td>${member.zipcode }</td></tr>
					<tr><th>주소</th><td>${member.address }</td></tr>
					<tr><th>전화번호</th><td>${member.phone }</td></tr>
					<tr><th>가입일자</th><td>${member.indate }</td></tr>
			</table>
		<div id="buttonbox">
			<input type="button" onclick="location.href='ModifyMemberInfo.jsp'" value="회원정보수정"><input type="button" onclick="location.href='ModifyPassword.jsp'" value="비밀번호수정">
		</div>
	</section>
	<footer>
	</footer>
</body>
</html>