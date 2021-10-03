<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table {
		width: 100%;
		border: 1px solid black;
		<-- border-collapse: collapse; -->
	}
	th,td{
		border-bottom: 1px solid black;
	}
	th {
		background-color : #eceff1;
	}
	tr:nth-child(even) {
		background-color : #f3ffe2;
	}
	tr:nth-child(odd) {
		background-color : #f0e8ff;
	}
	#date {
		display:flex;
		justify-content: center;
	}
</style>
</head>
<body>
	<table>
		<tr>
		<%
			for(int i=2; i< 10; i++){
		%>
	  		<th>
				<% out.println( i + "단"); %>
			</th>
			<%
				} 
			%>
		</tr>
		<%
			for(int i=1; i< 10; i++) {
		%>
		<tr>
			<%
				for(int j=2; j< 10; j++){ 
			%>
			<td>
				<%= i+ " * " +j + " = " + i*j %>
			</td>
			<%		 
				} 
			%>
		</tr>
		<%
			}
		%>
	</table>
	<%!
		Calendar today = Calendar.getInstance();
		String[] data = {"일","월","화","수","목","금","토"};
	%>
	<div id= "date">
		<%= 
			"지금은 " + today.get(Calendar.YEAR) + "년 " + (today.get(Calendar.MONTH)+1) + "월 " + today.get(Calendar.DATE) + "일 " + today.get(Calendar.HOUR)+":"+today.get(Calendar.MINUTE)+":"+today.get(Calendar.SECOND) +"입니다." 
		%>
		<%=  
		"(오늘은 " + data[today.get(Calendar.DAY_OF_WEEK)-1] + "요일)"
		%>
	</div>
</body>
</html>