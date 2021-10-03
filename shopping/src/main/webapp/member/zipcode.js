'use strict'

function search() {
	let dong = document.formz.dong.value;
	if(dong == '' || dong.trim().length == 0){
		alert('동을 입력해주세요.');
	}else {
		document.formz.submit();
	}
}

function inputAddress(zipcode,sido,gugun,dong,ri,bldg,bunji) {
	let arr = [sido,gugun,dong,ri,bldg,bunji];
	let address='';
	for(const arg of arr){
		if(arg != ""){
			address += (arg + " ");
		}
	}
	window.opener.inputAddress(address,zipcode);
	self.close();
}