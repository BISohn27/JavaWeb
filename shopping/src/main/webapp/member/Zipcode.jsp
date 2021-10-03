<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Zipcode</title>
<script src="/shopping/member/zipcode.js"></script>
<style>
	body{
		display: flex;
		flex-direction: column;
		align-items: center;
	}
	table{
		margin-top: 5vh;
		border: 1px solid lightgray;
		border-collapse: collapse;
	}
	th,td{
		border: 1px solid gray;
	}
	th{
		background-color: darkgray;
	}
	input.form{
		height: 3vh;
	}
</style>
</head>
<body>
	<div id="wrap">
		<form name="formz" action="/shopping/NonageServlet" method="get">
			<input class="form" type="text" name="dong" placeholder="동을 입력하세요."/><input class="form" type="button" onclick="search()" value="검색"/>
			<input type="hidden" name="command" value="zipcode"/>
		</form>
	</div>
	<c:choose>
		<c:when test="${not empty list}" >
			<table>
			<tr>
				<th>우편번호</th><th>시,도</th><th>구,군</th><th>동</th><th>리</th><th>빌딩</th><th>번지</th>
			</tr>
				<c:forEach var="address" items="${list }">
					<tr>
						<td>${address.zipcode }</td>
						<td>${address.sido }</td>
						<td>${address.gugun }</td>
						<td>${address.dong }</td>
						<td>${address.ri }</td>
						<td>${address.bldg }</td>
						<td>${address.bunji }</td>
						<td><input type="button" value="선택" onclick='inputAddress("${address.zipcode }","${address.sido }", "${address.gugun }", "${address.dong }", "${address.ri }", "${address.bldg }", "${address.bunji }")'/></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
		</c:otherwise>
	</c:choose>
</body>
</html>