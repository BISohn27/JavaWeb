<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	function modifyQna(){
		let memberId = $('input[name="id"]').val();
		let boardId = $('#writer').text();
		
		
		if(memberId != boardId){
			alert('다른 사람의 글을 수정할 수 없습니다.');
		} else{
			$('#formq').submit();
		}
	}
	
	function writeReply(){
		$('#replywriter').submit();
	}
	
	function modifyReply(){
		$('#modifyreply').submit();
	}
</script>
<style>
body{
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
		height:70vh;
	}
	article{
		display: flex;
		justify-content: center;
	}
	th, td{
		text-align: center;
	}
	th, #indate, #writer{
		height:2vh;
		background-color: lightgray;
	}
	td{
		background-color: white;
	}
	#writer{
		padding-right:3vw;
		text-align:right;
	}
	#content{
		height: 50%;
		width: 50%;
	}
	table{
		width:50%;
	}
	#indate {
		width: 20%;
	}
	#qseq{
		width: 5%;
	}
	#title{
		width: 75%;
	}
	#content{
		width:80%;
		height: 30vh;
		padding: 3vh;
		text-align: left;
		vertical-align: top;
	}
	#req{
		padding: 2vh;
		height: 20vh;
		text-align:left;
		vertical-align:top;
	}
	#buttonbox{
		background-color:#F5F5F5;
		text-align:right;
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
	<article>
		<table>
			<tr><th id="qseq">${board.qseq }</th><th id="title">${board.subject }</th><td id="indate">${board.indate }</td></tr>
			<tr><td id="writer" colspan="3">${board.id }</td></tr>
			<tr><td id="content" colspan="3" >${board.content }</td></tr>
		</table>
	</article>
	<article>
	<table>	
			<tr><td id="req">${board.reply }</td></tr>
			<tr><td id="buttonbox">
			<form id="formq" action="../view/modifyqna.jsp" method="post">
				<input type="hidden" name="page" value="${page }">
				<input type="hidden" name="totalpages" value="${totalpages }">
				<input type="hidden" name="content" value="${board.content }">
				<input type="hidden" name="subject" value="${board.subject }">
				<input type="hidden" name="qseq" value="${board.qseq }">
				<input type="hidden" name="id" value="${member.id }">
				<c:choose>
					<c:when test="${searchoption ne null }">
						<input type="button" value="수정" onclick="modifyQna()"><input type="button" value="목록" onclick="location.href='../customerservice/search.customerservice?&page=${page}&totalpages=${totalpages}&searchoption=${searchoption }&searching=${searching }'">
					</c:when>
					<c:when test="${member.id eq 'admin' }">
						<form>
						</form>
						<form id ="replywriter" action="../view/replywriter.jsp" method="post">
							<input type="hidden" value="${board.qseq }">
							<input type="hidden" name="page" value="${page }">
							<input type="hidden" name="totalpages" value="${totalpages }">
							<input type="hidden" name="id" value="${member.id }">
							<input type="hidden" value="${board.qseq }">
							<input type="button" value="답변" onclick="writeReply()">
						</form>
						<form id="modifyreply" action="../view/modifyreply.jsp" method="post">
							<input type="hidden" value="${board.qseq }">
							<input type="hidden" name="page" value="${page }">
							<input type="hidden" name="totalpages" value="${totalpages }">
							<input type="hidden" name="id" value="${member.id }">
							<input type="hidden" name="reply" value="${board.reply }">
							<input type="button" value="답변수정" onclick="modifyReply()">
						</form>
						<input type="button" value="목록" onclick="location.href='../customerservice/search.customerservice?&page=${page}&totalpages=${totalpages}&searchoption=${searchoption }&searching=${searching }'">
					</c:when>
					<c:otherwise>
						<input type="button" value="수정" onclick="modifyQna()"><input type="button" value="목록" onclick="location.href='../customerservice/qna.customerservice?&page=${page}&totalpages=${totalpages}'">
					</c:otherwise>
				</c:choose>
			</form>
			</td></tr>
		</table>
	</article>
</section>
</body>
</html>