<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Login</title>
</head>
<script type="text/javascript">
			function checkinput(){
				if(document.getElementById("username").value==""){
					alert("No User Name Input");
					document.getElementById("username").focus();
					return false;
				}
				if(document.getElementById("password").value==""){
					alert("No Password Input");
					document.getElementById("password").focus();
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
	
	<form name="loginForm" action="UserLoginS" method="post" onsubmit="return checkinput()">
		<div align="center">
			<h1>User Login</h1>
			User Name: <input type="text" id="username" value="" name="username"
				size="38" maxLength="22" /> 
				<br /> 
				<br /> 
			Password: &nbsp<input type="password" id="password" value="" name="password"
				size="38" maxLength="22"  /> 
				<br /> 
				<br /> 
				<input type="Submit" name="submit" style="width: 210px" value="Login" />
			 	<input type="Reset" name="reset" style="width: 210px" value="Reset" />
				
		</div>
	</form>
</body>
</html>