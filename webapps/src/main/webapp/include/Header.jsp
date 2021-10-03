<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.UserInfo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
		#loginbox {
			background-color:#00008b;
			color:#ffffff; 
			height:40px; 
			padding: 5px;
			display:flex;
			text-align: right;
			}
		</style>
</head>
<%-- <jsp:useBean id="userinfo" scope="session" class=dto.UserInfoUserInfo"/> --%>
<%
	UserInfo userinfo = (UserInfo)session.getAttribute("userinfo");
%>
<body>
	<div id="loginbox">
	<% if(userinfo !=null && userinfo.getId() != null) { %>
		<%=userinfo.getName() %>
		<input type="button" value="로그아웃" onclick="location.href='/webapps/UserInfoLogOutServlet'">
		<input type="button" value="수정" onclick="location.href='/webapps/UserInfoUpdateServlet?id=${userinfo.id}'">
		<input type="button" value="회원목록" onclick="location.href='/webapps/UserInfoListServlet'">
	<%
		} else{ %>
			<form method = "post" action = "/webapps/UserInfoLoginServlet">
				<table>
					<tr>
						<th align="right">I D :</th> 
						<td><input type = "text" name = "id" size = "20"></td>
					</tr>
					<tr>
						<th align="right">PW :</th>
						<td><input type = "text" name = "pw" size = "20"></td>
					</tr>
				</table>
				<input type = "submit" value=" 로그인"><input type = "reset" value = "지우기"><input type="button" onclick="location.href='/webapps/jsp/MemberForm.jsp'" value="회원가입">
				</form>
		<%  }%>
		</div>
</body>
</html>