<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="java.sql.*, webapps.DBAction,com.example.sba.domain.UserInfo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID Validation</title>
<%-- <%!
	Connection conn = DBAction.getInstance().getConnection();
%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id").trim();
	String sql = "SELECT ID FROM USERINFO WHERE ID=?";
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	UserInfo userinfo = null;
	try{
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,id);
		rs = pstmt.executeQuery();
		if(rs.next()){
			userinfo = new UserInfo().setId(rs.getString("ID"));
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
%> --%>
<%-- <jsp:useBean id="userinfo" class="dto.UserInfo" scope="request" /> --%>
<% UserInfo userinfo = (UserInfo)request.getAttribute("userinfo"); %>
</head>
<body>
	<br><p><center><hr><br></p>
	
	<%if(userinfo != null) { %>
	<%=	userinfo.getId() + "는 사용 할 수 없는 아이디입니다." %>
	<input type="button" value="닫기" onclick="window.close()" />
	<% }else { %>
		<%= request.getParameter("id") + "는 사용 가능한 아이디 입니다." %>
	<input type="button" value="닫기" onclick="window.close()" />
	<% } %>
</body>
</html>