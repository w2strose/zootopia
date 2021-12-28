function Login(){
	url="login.jsp";
	window.open(url, "post", "toolbar=no, width=500, height=300, directories=no, status=yes, scrollbars=yes, menubar=no");
}

function idCheck(id){
	if(id == ""){
		alert("아이디를 입력해주세요");
		document.regForm.id.focus();
	}else{
		url="idCheck.jsp?id="+id;
		window.open(url, "post", "width=300, height=150");
	}
}


function inputCheck(){
	if(document.regForm.id.value == ""){
		alert("id를 입력해주세요");
		document.regForm.id.focus();
		return ;
	}	
	if(document.regForm.pass.value == ""){
		alert("비밀번호를 입력해주세요");
		document.regForm.pass.focus();
		return ;
	}	
	if(document.regForm.repass.value == ""){
		alert("비밀번호를 다시 확인해주세요");
		document.regForm.repass.focus();
		return ;
	}	
	if(document.regForm.pass.value != document.regForm.repass.value){
		alert("비밀번호가 일치하지 않습니다.");
		document.regForm.repass.focus();
		return ;
	}	
	if(document.regForm.name.value == ""){
		alert("이름을 입력해주세요");
		document.regForm.name.focus();
		return ;
	}
	if(document.regForm.phone1.value == ""){
		alert("통신사를 입력해주세요");
		document.regForm.phone1.focus();
		return ;
	}
	if(document.regForm.phone2.value == ""){
		alert("전화번호를 입력해주세요");
		document.regForm.phone2.focus();
		return ;
	}
	if(document.regForm.phone3.value == ""){
		alert("전화번호를 입력해주세요");
		document.regForm.phone3.focus();
		return ;
	}
	if(document.regForm.email.value == ""){
		alert("이메일을 입력해주세요");
		document.regForm.email.focus();
		return ;
	}
	
	var str=document.regForm.email.value;
	var atPos=str.indexOf('@');
	var atLastPos=str.lastIndexOf('@');
	var dotPos=str.indexOf('.');
	var spacePos=str.indexOf(' ');
	var commaPos=str.indexOf(',');
	var eMailSize=str.length;
	if(atPos > 1 && atPos == atLastPos && dotPos >3 && spacePos == -1 && commaPos == -1&& atPos+1 < dotPos && dotPos +1 < eMailSize);
	else{
		alert('E_mail 주소 형식을 잘못입력하셨습니다. \n\r 다시 입력해주세요');
		document.regForm.email.focus();
		return;
	}
	
	if(document.regForm.birth.value == ""){
		alert("생년월일을 입력해주세요");
		document.regForm.birth.focus();
		return ;
	}
	
	document.regForm.submit();
}


function updateCheck(){
	
	if(document.regForm.pass.value == ""){
		alert("비밀번호를 입력해주세요");
		document.regForm.pass.focus();
		return ;
	}	
	if(document.regForm.repass.value == ""){
		alert("비밀번호를 다시 확인해주세요");
		document.regForm.repass.focus();
		return ;
	}	
	if(document.regForm.pass.value != document.regForm.repass.value){
		alert("비밀번호가 일치하지 않습니다.");
		document.regForm.repass.focus();
		return ;
	}	
	if(document.regForm.phone1.value == ""){
		alert("통신사를 입력해주세요");
		document.regForm.phone1.focus();
		return ;
	}
	if(document.regForm.phone2.value == ""){
		alert("전화번호를 입력해주세요");
		document.regForm.phone2.focus();
		return ;
	}
	if(document.regForm.phone3.value == ""){
		alert("전화번호를 입력해주세요");
		document.regForm.phone3.focus();
		return ;
	}
	
	if(document.regForm.email.value == ""){
		alert("이메일을 입력해주세요");
		document.regForm.email.focus();
		return ;
	}
	
	var str=document.regForm.email.value;
	var atPos=str.indexOf('@');
	var atLastPos=str.lastIndexOf('@');
	var dotPos=str.indexOf('.');
	var spacePos=str.indexOf(' ');
	var commaPos=str.indexOf(',');
	var eMailSize=str.length;
	if(atPos > 1 && atPos == atLastPos && dotPos >3 && spacePos == -1 && commaPos == -1&& atPos+1 < dotPos && dotPos +1 < eMailSize);
	else{
		alert('E_mail 주소 형식을 잘못입력하셨습니다. \n\r 다시 입력해주세요');
		document.regForm.email.focus();
		return;
	}
	
	if(document.regForm.birth.value == ""){
		alert("생년월일을 입력해주세요");
		document.regForm.birth.focus();
		return ;
	}
	
	document.regForm.submit();
}



function checkIt(){
	if(!document.myForm.pass.value){
		alert("비밀번호를 입력하지 않았습니다.");
		document.myForm.pass.focus();
		return false;
	}
}
