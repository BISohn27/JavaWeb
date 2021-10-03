<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body{
		font-size: small;
	}
	table {
		border: 1px solid gray;
		border-collapse: collapse;
	}
	th,td {
		border: 1px solid gray;
		border-collapse: collapse;
	}
</style>
</head>
<body>
	<table>
		<tr><th>데이터 형</th><th>EL 코드</th><th>실행 결과</th></tr>
		<tr><th>문자열</th><th>\${"test"}</th><th>${"test"}</th></tr>
		<tr><th>문자열</th><th>\${'test'}</th><th>${'test'}</th></tr>
		<tr><th>정수</th><th>\${10}</th><th>${10}</th></tr>
		<tr><th>부동소수점</th><th>\${3.14}</th><th>${3.14}</th></tr>
		<tr><th>불리언</th><th>\${true}</th><th>${true}</th></tr>
		<tr><th>널</th><th>\${null}</th><th>${null}</th></tr>
	</table>
</body>
</html>