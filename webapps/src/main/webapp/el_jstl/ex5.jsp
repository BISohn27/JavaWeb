<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>c:set 태그</h2>
	<h3>값 설정 방식</h3>
<!-- 변수를 username1으로 선언하고 선언된 변수에 홍길동이라는 값을 주겠다는 것 -->
	<c:set var="username1" value="홍길동"/> <%-- <% String username1 = "홍길동"; %> --%>
	<c:set var="username2">임꺽정</c:set>
	${username1}
	${username2}
	<h3>기본 보관소 - page</h3>
	${pageScope.username1}<br>
	${requestScope.username1}<br>
	<h3>보관소 지정- scope 속성</h3>
	<c:set var="username3" scope="request">일지매</c:set>
	${pageScope.username3}<br>
	${requestScope.username3}<br>
	<h3>기존의 값 덮어씀</h3>
	<% pageContext.setAttribute("username4","똘이장군"); %>
	기존 값=${username4}<br>
	<c:set var="username4" value="주먹대장"/>
	덮어쓴 값=${username4}<br>
	<h3>객체의 프로퍼티 값 변경</h3>
	<%!
	public class MyMember {
		private int no;
		private String name;
		
		public int getNo(){
			return no;
		}
		public void setNo(int no){
			this.no = no;
		}
		public String getName(){
			return name;
		}
		public void setName(String name){
			this.name=name;
		}
	}
	%>
	<%
		MyMember member = new MyMember();
		member.setNo(100);
		member.setName("홍길동");
		pageContext.setAttribute("member", member);
	%>
	${member.name}<br>
	<c:set target="${member}" property="name" value="임꺽정"/>
	${member.name}<br>
</body>
</html>