'use strict';

function idCheck(){
	let id = $('#id').val();
	if(id == "" || id.trim().length === 0) {
		alert('아이디를 입력해주세요.');
		document.formm.id.focus();
		return;
	}else if(id.trim().length !== id.trim().length) {
		alert('아이디에 공백을 사용할 수 없습니다.');
		document.formm.id.focus();
		return;
	} else{
		$.ajax({
			type: "post",
			async: true,
			url:"/shopping/NonageServlet?command=idcheck",
			dataType: "text",
			data: {id: id},
			success: function(data,textStatus){
				if(data == 'usable') {
					alert('사용할 수 있는 아이디입니다.');
					$('#checkbutton').prop("disabled",true);
				}else{
					alert('사용할 수 없는 아이디입니다.');
				}
			},
			error: function(data, textStatus) {
				alert('에러가 발생했습니다.');
			},
			complete:function(data,textStatus) {}
		});
		/*let url = "/shopping/NonsageServlet?command=idcheck&id="
			+document.formm.id.value;
		window.open(url,"_blank_1","toolbar=no, menubar=no,scrollbars=yes,resizable=no, width=400, height=200");*/
	}
}

function searchPost(){
		window.open('Zipcode.jsp','zip','width=800,height=600');
}

function inputAddress(address,zipcode){
	formm.zipcode.value = zipcode;
	formm.address.value = address; 
}

function goSave(){
	let id = document.formm.id.value;
	let pwd = document.formm.pwd.value;
	let name = document.formm.name.value;
	let emailid = document.formm.emailid.value;
	let emailaddress = document.formm.emailaddress.value;
	let address = document.formm.address.value;
	let phone = document.formm.phone.value;
	if(id == "" || id.trim().length == 0){
		alert('아이디를 입력해주세요.');
	}else if(pwd == "" || pwd.trim().length == 0){
		alert('패스워드를 입력해주세요.');
	}else if(name == "" || name.trim().length == 0){
		alert('이름을 입력해주세요.');
	}else if(emailid == "" || emailid.trim().length == 0){
		alert('이메일 아이디를 입력해주세요.');
	}else if(emailaddress == "" || emailaddress.trim().length == 0){
		alert('이메일 주소를 입력해주세요.');
	}else if(address == "" || address.trim().length == 0){
		alert('주소를 입력해주세요.');
	}else if(phone == "" || phone.trim().length == 0){
		alert('전화번호를 입력해주세요.');
	}else {
		document.formm.action = "/shopping/NonageServlet?command=join";
		document.formm.method = "post";
		document.formm.submit();
	}
}