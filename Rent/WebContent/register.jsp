<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Register</title>
</head>

<script type="text/javascript">
	function checkinput() {
		if(document.getElementById("username").value.length < 6){
			alert("User Name Is Too Short");
			document.getElementById("username").focus();
			return false;
		}
		if(document.getElementById("address").value.length < 6){
			alert("Address Is Too Short");
			document.getElementById("username").focus();
			return false;
		}
		if(document.getElementById("password").value.length < 6){
			alert("Password Is Too Short");
			document.getElementById("password").focus();
			return false;
		}
		if(document.getElementById("password").value!=document.getElementById("passwordConfirm").value){
			alert("Not Same");
			document.getElementById("passwordConfirm").focus();
			return false;
		}
		if(document.getElementById("realname").value.length <= 0){
			document.getElementById("realname").focus();
			alert("No Input");
			return false;
		}
		var temp = document.getElementById("email");
		var emailStr = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
		if(!emailStr.test(temp.value)){
			alert('Wrong Format');
			temp.focus();
			return false;
		}
	}

</script>

<body>
	<span style = "color:red; font-weight:bold">
	<%
		if (request.getAttribute("err") != null){
			out.println(request.getAttribute("err") + "</br>");
		}
	%>
	</span>
	
	<form name="registerForm" action="UserRegisterS" method="post" onsubmit="return checkinput()">
		<div align="center">
			<h1>User Register</h1>
			User Name: <input type="text" id="username" value="" name="username"
				size="38" maxLength="22" /> 
				<br /> 
				<br /> 
			Name: &nbsp<input type="text" id="realname" value="" name="realname"
				size="38" maxLength="22" /> 
				<br /> 
				<br /> 
			Address: &nbsp<input type="text" id="address" value="" name="address"
				size="38" maxLength="22" /> 
				<br /> 
				<br /> 
			Password: &nbsp<input type="password" id="password" value="" name="password"
				size="38" maxLength="22"  /> 
				<br /> 
				<br /> 
			Confirm Password: &nbsp<input type="password" id="passwordConfirm" value="" name="passwordConfirm"
				size="38" maxLength="22" /> 
				<br /> 
				<br /> 
			E-Mail: <input type="text" id="email" value="" name="email" size="38"
				maxLength="22" /> 
				<br /> 
				<br /> 
				<input type="Submit" name="submit" style="width: 210px" value="Register" />
			 	<input type="Reset" name="reset" style="width: 210px" value="Reset" />
				<input type="button" name="gotologin" style="width: 210px" value="login" onclick="window.location='login1.jsp'"/>
		</div>
	</form>
</body>
</html>