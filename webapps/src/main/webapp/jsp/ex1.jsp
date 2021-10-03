<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>안녕하세요, JSP 페이지입니다.</p>
	[scriptlet]: 자바코드구현
	 <%
           int su1=20;
           int su2=10;
           int sum = su1+su2;
           out.println(sum);
           %>
    [declaration] : 변수 선언 및 메소드를 정의
    <%!
    	String str = "Hello,JSP";
    	int su1 =5;
    	
    	public int method(){
    	return su1;
    	}
    %>
    [expression] : 문자열 출력  <%= "msg" %>
    <%= method() %>
   	
   	<%--
   		<%= 변수; %> 개발자가 작성한 표현식에 ;를 넣으면 웹 컨테이너는 out.println()으로 변환시킴 
   		--%>
</body>
</html>