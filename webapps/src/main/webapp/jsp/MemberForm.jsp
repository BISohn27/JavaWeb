<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type ="text/javascript">
	function fn_sendMember(){
		/* alert("fn_sendMember()"); */
		var frmMember = document.frmMember;
		var id=frmMember.id.value;
		var pw=frmMember.pw.value;
		var name = frmMember.name.value;
		var email = frmMember.email.value;
		if(id.trim().length == 0 || id == ''){
			alert("아이디는 반드시 입력해야 합니다.");
		}  else if(pw.trim().length == 0 || pw == '') {
			alert("패스워드는 반드시 입력해야 합니다.")
		} else if(name.trim().length == 0 || name == ''){
			alert("이름은 반드시 입력해야 합니다.");
		}  else if(email.trim().length == 0 || email == ''){
			alert("이메일은 반드시 입력해야 합니다.");
		} else{
			frmMember.method="post";
			frmMember.action="/webapps/UserInfoAddServlet";
			frmMember.submit();
		}
	
	}
	function checkId(){
		var id=frmMember.id.value;
		if(id.trim().length==0 || id==''){
			alert("아이디는 반드시 입력해야 합니다.");
		} else {
			window.open('/webapps/CheckIdServlet?id=' + id,'pop', 'width=300,height=300');
		}
	}
	function searchPost(){
		window.open('Zipcode.jsp','zip','width=800,height=600');
	}
	function inputZipcode(zipcode){
		frmMember.zipcode.value=zipcode;
	}
</script>
</head>
<body>
	<form name="frmMember">
	<table>
	<tr>
		<th>회원 가입창</th>
	</tr>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="id" ><input type="button" value="아이디중복" onclick="checkId()"/></td><!-- <input type="button" value="아이디중복" onclick="location.href='/webapps/CheckIdServlet?id=asdfa'"></td> -->
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="pw" ></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="name" ></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="email" ></td>
	</tr>
	<tr>
		<td>우편번호</td>
		<td><input type="text" name="zipcode"/><input type="button" value="우편번호검색" onclick="searchPost()"/></td>
	</tr>
	</table>
		<input type="button" value="가입하기" onclick='fn_sendMember()'/>
		<input type="reset" value="다시입력">
		<input type="hidden" name="command" value="addMember" />
		<jsp:include page="../include/Footer.jsp" />
	</form>
</body>
</html>