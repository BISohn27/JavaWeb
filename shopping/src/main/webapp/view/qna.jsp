<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		height:70vh;
		display:flex;
		flex-direction: column;
		align-items: center;
	}
	#boardarticle{
		height: 60vh;
		display: flex;
		justify-content: center;
		align-items: flex-start;
	}
	#pagearticle{
		height: 10vh;
		width: 30%;
		display: flex;
		justify-content: space-evenly;
	}
	a.boardselection{
		text-decoration:none;
		color: black;
	}
	a.boardselection:hover{
		color:lightgray;
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
	<article id="boardarticle">
		<table>
			<tr>
				<th>글번호</th><th>제목</th><th>글쓴이</th><th>작성일자</th>
			</tr>
			<c:forEach var="board" items="${ qnalist}">
				<tr>
					<td>${board.qseq }</td><td><a class="boardselection" href="../customerservice/board.customerservice?qseq=${board.qseq }">${board.subject }</a></td><td>${board.id }</td><td>${board.indate }</td>
				</tr>
			</c:forEach>	
		</table>
	</article>
	<article id="pagearticle">
		<c:choose>
			<c:when test="${page <= 10 }">
				<span>이전 </span>
			</c:when>
			<c:otherwise>
				<a href="../customerservice/qna.customerservice?page=${startpage-1 }&totalpages=${totalpages}">이전 </a>
			</c:otherwise>
		</c:choose>
		<c:forEach var="i" begin="${startpage }" end="${endpage }">
			<c:choose>
				<c:when test="${i eq page }">
					<span id="currentpage">${i } </span>
				</c:when>
				<c:otherwise>
					<a class="pages" href="../customerservice/qna.customerservice?page=${i }&totalpages=${totalpages}">${i } </a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${(endpage % 10) ne 0 }">
				<span>다음</span>
			</c:when>
			<c:otherwise>
				<a href="../customerservice/qna.customerservice?page=${endpage + 1 }&totalpages=${totalpages}">다음 </a>
			</c:otherwise>
		</c:choose>
	</article>
</section>
</body>
</html>