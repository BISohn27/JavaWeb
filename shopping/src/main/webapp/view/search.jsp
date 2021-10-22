<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	function sendSearch(){
		let searching = $('#textbox').val();
		
		if(searching == '' || searching.trim().length ==0){
			alert('검색어를 입력해주세요.');
		}else{
			$('forms').submit();
		}
	}
</script>
<style>
body {
	background-color: #F5F5F5;
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

section {
	height: 70vh;
	display: flex;
	flex-direction: column;
	align-items: center;
}

table {
	width: 60%;
}

th, td {
	width: 8%;
	height: 3vh;
	text-align: center;
}

th {
	background-color: darkgray;
}

td {
	background-color: white;
}

.title {
	width: 30%;
}

#boardarticle {
	height: 40vh;
	width: 100%;
	display: flex;
	justify-content: center;
	align-items: flex-start;
}

#pagearticle {
	height: 10vh;
	width: 80%;
	display:flex;
	flex-direction: column;
	align-items:center;
}

#currentpage {
	font-weight: bolder;
}

#buttonbox {
	background-color: #F5F5F5;
	text-align: right;
}

a.boardselection {
	text-decoration: none;
	color: black;
}

a.boardselection:hover {
	color: lightgray;
}

.pagination, .pages {
	text-decoration: none;
	color: black;
}

.pagination:hover, .pages:hover {
	text-decoration: underline;
}

#textbox {
	background-color: white;
	width: 70%;
	height: 100%;
	padding: 10px 20px;
	border: 1px solid lightgray;
	border-radius: 5px;
}

#btn {
	color: rgb(34, 33, 33);
	padding: 10px 20px;
	background-color: #c4d3da;
	border: none;
	border-radius: 5px;
}

#pagingbox{
	width:50%;
	padding-top:10px;
	display:flex;
	justify-content: space-evenly;
}

form{
	width:100%;
	display: flex;
	justify-content: center;
}

#selectbox{
	background-color: white;
	border: 1px solid lightgray;
	border-radius: 5px;
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
					<th>글번호</th>
					<th class="title">제목</th>
					<th>글쓴이</th>
					<th>작성일자</th>
				</tr>
				<c:choose>
				<c:when test= "${qnalist ne null}">
				<c:forEach var="board" items="${ qnalist}">
					<tr>
						<td>${board.qseq }</td>
						<td class="title"><a class="boardselection"
							href="../customerservice/board.customerservice?qseq=${board.qseq }&page=${page}&totalpages=${totalpages}">${board.subject }</a></td>
						<td>${board.id }</td>
						<td>${board.indate }</td>
					</tr>
				</c:forEach>
				<tr>
					<td id="buttonbox" colspan="4"><c:choose>
							<c:when test="${member eq null }">
								<input type="button" value="글쓰기"
									onclick="location.href='../member/Login.jsp'">
							</c:when>
							<c:otherwise>
								<input type="button" value='글쓰기'
									onclick="location.href='../customerservice/writer.customerservice'">
							</c:otherwise>
						</c:choose></td>
				</tr>
			</table>
		</article>
		<article id="pagearticle">
			<div id="searchbox">
				<form id="forms" action="../customerservice/search.customerservice"
					method="post">
					<select name="searchoption" id="selectbox">
						<option value="1">제목</option>
						<option value="2">제목+내용</option>
						<option value="3">작성자</option>
					</select>
					<input type="text" id="textbox" name="searching"
						placeholder="검색어를 입력해주세요."><button id="btn" type="button" onclick="sendSearch()">
						<i class="fas fa-search"></i>
					</button>
				</form>
			</div>
			<div id="pagingbox">
			<c:choose>
				<c:when test="${page <= 10 }">
					<span>이전 </span>
				</c:when>
				<c:otherwise>
					<a class="pagination"
						href="../customerservice/search.customerservice?page=${startpage-1 }&totalpages=${totalpages}">이전
					</a>
				</c:otherwise>
			</c:choose>
			<c:forEach var="i" begin="${startpage }" end="${endpage }">
				<c:choose>
					<c:when test="${i eq page }">
						<span id="currentpage">${i } </span>
					</c:when>
					<c:otherwise>
						<a class="pages"
							href="../customerservice/search.customerservice?page=${i }&totalpages=${totalpages}">${i }
						</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${(endpage % 10) ne 0 }">
					<span>다음</span>
				</c:when>
				<c:otherwise>
					<a class="pagination"
						href="../customerservice/search.customerservice?page=${endpage + 1 }&totalpages=${totalpages}">다음
					</a>
				</c:otherwise>
			</c:choose>
			</div>
		</article>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="4" rowspan="4">검색 결과가 없습니다.</td>
		</table>
		</article>
		<article id="pagearticle">
			<div id="searchbox">
				<form id="forms" action="../customerservice/search.customerservice"
					method="post">
					<select name="searchoption" id="selectbox">
						<option value="1">제목</option>
						<option value="2">제목+내용</option>
						<option value="3">작성자</option>
					</select>
					<input type="text" id="textbox" name="searching"
						placeholder="검색어를 입력해주세요."><button id="btn" type="button" onclick="sendSearch()">
						<i class="fas fa-search"></i>
					</button>
				</form>
			</div>
			<div id="pagingbox">
				<span>이전 </span>
				<span id="currentpage">1</span>
				<span>다음</span>
			</div>
		</article>
		</c:otherwise>
		</c:choose>
	</section>
</body>
</html>