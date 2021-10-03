<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dfffdfff</title>
</head>
<body>
	<table>
		<tr><th>분류</th><th>연산자</th><th>EL 코드 = 실행 결과</th></tr>
		<tr><td>산술</td><td>+, -, *, /(div), %(mod)</td>
		<tr><td>
				<pre>
				\${10 + 20} = ${10 + 20}
				\${10-  20} = ${10-  20}
				\${10 * 20} = ${10 * 20}
				\${10 / 20} = ${10 / 20}
				\${10 mod 20} = ${10 mod 20}
				</pre>
			</td>
		</tr>
		<tr><td>관계</td><td>== , != , &lt;, &gt;, &le;, &ge;</td>
		<tr><td>
				<pre>
				\${10 == 20} = ${10 == 20}
				\${10 eq 20} = ${10 eq 20}
				\${10 !=  20} = ${10 != 20}
				\${10 lt 20} = ${10 lt 20}
				\${10 < 20} = ${10 < 20}
				\${10 gt 20} = ${10 gt 20}
				\${10 > 20} = ${10 > 20}
				\${10 le  20} = ${10 le 20}
				\${10 <= 20} = ${10 <= 20}
				\${10 ge 20} = ${10 ge 20}
				\${10 >= 20} = ${10 >= 20}
				</pre>
			</td>
		</tr>
		<tr><td>\${empty title}</td> <td>${empty title}</td></tr>
	</table>
</body>
</html>