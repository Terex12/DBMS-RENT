<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<link rel="stylesheet" type="text/css" href="./CSS/css.css" />
<title>GatorRental HTML Version</title>
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
<div class="menu">
<ul>
<li style="width:0px;"><a></a></li>
<li class="active"><a href="index.html" class="home">Home</a></li>
<li style="float:right;"><a href="login.jsp" class="login">Login</a></li>
<!--<li style="float:right;"><a class="register">Register</a></li>-->
</ul>
</div>


<div class="header">
<div class="logo_img"><a href="index.html"><img src="images/Florida_Gators_script_logo.png" alt="Site Name" width="200" height="60"></a></div></div>

<br>
<br>
<br>
<div>
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
				<input type="button" name="gotologin" style="width: 210px" value="login" onclick="window.location='login.jsp'"/>
		</div>
	</form>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div class="icart-footer">
<div class="icart-footer-top">
	<div style="width:1000px; margin:0 auto;">	
	</div>
</div>
<div class="icart-footer-container">
	<div class="column_footer" style="width:350px;">
		<h3>About Us</h3>
<div class="footer_description">
		<p>A group of Computer Science major student from University of Florida developing a website implementing Oracle database. </p>
		<p>The group includes: Liu Zhengzheng, Xu Yufan, Wang Xi, Jiang Li</p>
</div>
	</div>
	
	<div class="column_footer">
		<h3>Customer Service</h3>
		<ul>
      		<li><a href="#">Delivery Information</a></li>
      		<li><a href="#">Privacy Policy</a></li>
      		<li><a href="#">Terms &amp; Conditions</a></li>
      		<li><a href="#">Contact Us</a></li>
      		<li><a href="#">Returns</a></li>
      		<li><a href="#">Site Map</a></li>
		</ul>
	</div>
	
	<div class="column_footer" style="width:150px;">
		<h3>Extras</h3>
		<ul>
      		<li><a href="#">Brands</a></li>
      		<li><a href="#">Gift Vouchers</a></li>
      		<li><a href="#">Affiliates</a></li>
      		<li><a href="#">Specials</a></li>
		</ul>
	</div>	
	<div class="column_footer" style="width:150px;">
		<h3>My Account</h3>
		<ul>
      		<li><a href="#">My Account</a></li>
      		<li><a href="#">Order History</a></li>
      		<li><a href="#">Wish List</a></li>
      		<li><a href="#">Newsletter</a></li>
		</ul>
</div>
		
	<div class="column_footer" style="margin-right:0px;">
		<h3>Social</h3>
		<ul class="social">
			<li class="twitter"><a href="../../twitter.com/twitter">Twitter Username</a></li>
			<li class="facebook"><a href="../../facebook.com/Username/default.htm">Facebook</a></li>
			<li class="rss"><a href="#">RSS Feed</a></li>
		</ul>				
	</div>		
	<div class="clearfix"></div>
  </div>		
	<div class="icart-footer-bottom">
		<div style="width:1000px; margin:0 auto;">				
		<div class="icart-logo-footer"></div>	
			<ul>
			<li style="float:right;padding-top:10px;list-style:none;"></li>
			</ul>		
		<div class="clearfix"></div>
		</div>

</div>
</div>

</body>
</html>