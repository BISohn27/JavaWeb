<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="java.sql.*, java.util.* , vo.AddressVo"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ZipcodeSearch</title>
<script>
	function inputZipcode(zipcode){
		window.opener.inputZipcode(zipcode);
		self.close();
	}
</script>
</head>
<body>
	<h1>우편번호검색</h1>
	<form action="/webapps/PostServlet" method="post">
		동 이름 : <input type="text" name="dong"/>
		<input type="submit" value="찾기"/>
	</form>
		<%
			request.setCharacterEncoding("utf-8");
			ArrayList<AddressVo> list = (ArrayList<AddressVo>)request.getAttribute("zip");
			if(list ==null) {
				return;
			}else{
		%>
					<table border="1">
		<tr>
			<th>우편번호</th>
			<th>시</th>
			<th>구군</th>
			<th>동</th>
			<th>리</th>
			<th>빌딩</th>
			<th>번지</th>
		</tr>
		<%
				for(AddressVo data : list) { %>
		<tr>
			<td><%= data.getZipcode() %></td>
			<td><%= data.getSido() %></td>
			<td><%= data.getGugun() %></td>
			<td><%= data.getDong() %></td>
			<td><%= data.getRi() %></td>
			<td><%= data.getBldg() %></td>
			<td><%= data.getBunji() %></td>
			<td><input type="button" value="선택" onclick="inputZipcode('<%= data.getZipcode()%>')"></td>
		</tr>
		<%      }
		     } %>
	</table>
</body>
</html>