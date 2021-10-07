<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.example.sba.domain.UserInfo" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table{
	border: 1px solid gray;
	border-collapse: collapse;
}
th,td{
	border: 1px solid gray;
}
th{
	background-color: lightgray;
}
</style>
</head>
<%
		pageContext.setAttribute("scores", new int[]{90,80,70,100});
		List<String> nameList = new LinkedList<String>();
		nameList.add("홍길동");
		nameList.add("임꺽정");
		nameList.add("일지매");
		pageContext.setAttribute("nameList", nameList);
		Map<String,String> map = new HashMap<String,String>();
		map.put("s01","홍길동");
		map.put("s02","임꺽정");
		map.put("s03","일지매");
		pageContext.setAttribute("map",map);
		pageContext.setAttribute("userinfo",new UserInfo().setId("adc").setPw("123").setName("홍길동"));
	%>
<body>
<p><a href="ex1.jsp">[이전]</a><a href="ex3.jsp">[다음]</a></p>
	<h2>EL - 값 꺼내기</h2>
	<table>
	<tr><th>대상</th><th>EL 코드</th><th>설명</th></tr>
	<tr>
	<td>배열</td><td>\${myArray[1]}</td>
	<td>배열에서 해당 인덱스의 값을 꺼낸다.<br>
	<pre>
	[자바코드]
	pageContext.setAttribute("scores", new int[]{90,80,70,100});
	[실행결과]
	\${scores[2]}= ${scores[2]}
	</pre>
	</td>
	</tr>
	<tr>
	<td>리스트</td><td>\${myList[1]}</td>
	<td>객체에서 인덱스로 지정된 항목의 값을 꺼낸다.<br>
	<pre>
	[자바코드]
	List nameList = new LinkedList();
	nameList.add("홍길동");
	nameList.add("임꺽정");
	nameList.add("일지매");
	pageContext.setAttribute("namelist", nameList);
	[실행결과]
	\${nameList[2]}= ${nameList[1]}
	</pre>
	</td>
	</tr>
	<tr>
	<td>맵</td><td>\${myMap.keyName}</td>
	<td>Map 객체에서 지정된 키에 해당하는 값을 꺼낸다.<br>
	<pre>
	[자바코드]
	Map map = new HashMap();
	map.put("s01","홍길동");
	map.put("s02","임꺽정");
	map.put("s03","일지매");
	pageContext.setAttribute("map",map);
	[실행결과]
	\${map.s02}= ${map.s02}
	</pre>
	</td>
	</tr>
	<tr>
	<td>자바빈</td><td>\${myObj.propName}</td>
	<td>자바 객체에서 프로퍼티 값을 꺼낸다.<br>
	<pre>
	[자바코드]
	pageContext.setAttribute("userinfo",new UserInfo().setId("adc").setPw("123").setName("홍길동"));
	[실행결과]
	\${userinfo.name}= ${userinfo.name}
	</pre>
	</td>
	</tr>
	</table>
</body>
</html>