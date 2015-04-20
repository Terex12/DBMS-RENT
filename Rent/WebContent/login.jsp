<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<link rel="stylesheet" type="text/css" href="./CSS/css.css" />
<title>iCart HTML Version</title>
</head>
<body>
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

<style type="text/css">
/* content */
#content .content {
	padding: 10px;
	overflow: auto;
	margin-bottom: 20px;
	width:350px;float:left;
    	background-color: #eee;
    	border: 1px solid #BBBBBB;
	box-shadow: 1px 1px 1px #FFFFFF inset;	
	margin-right:20px;

}
</style>

<div class="menu">
<ul>
<li style="width:0px;"><a></a></li>
<li><a href="welcom.html" class="home">Home</a></li>
<li class="active" style="float:right;"><a href="login.jsp" class="login">Login/Register</a></li>
<!--<li style="float:right;"><a class="register">Register</a></li>-->
</ul>
</div>



<div class="header">
<div class="logo_img"><a href="index.html"><img src="images/Florida_Gators_script_logo.png" alt="Site Name" width="200" height="60"></a></div></div>

<div id="menu">
</div>




<div style="width:1000px;margin: 0 auto;margin-top:10px;">
<div class="linktree">
        <a href="../../oc.spthemes.us/index.php@route=common_2Fhome">Home</a>
         &raquo; <a href="../../oc.spthemes.us/index.php@route=account_2Faccount">Account</a>
         &raquo; <a href="../../oc.spthemes.us/index.php@route=account_2Flogin">Login</a>
    </div>

  <h1 style="margin-top:-10px;">Account Login</h1>

<br>



 
<div id="column-right">
    <div class="box">
  <div class="box-heading_left">Account</div>
  <div class="box-content" style="background:none;border: solid 1px #E3E3E2;"><div class="box-category">
    <ul>
      <li><a href="login.jsp">Login</a> / <a href="register.jsp">Register</a></li>
      <li><a href="StatisticS">Data Statistic</a></li>
      <li><a href="#">Returns</a></li>
          </ul>
  </div>
</div>
</div>
  </div>
<div id="content">
      <div class="login-content">
    <div class="left">
      <h2>New Customer</h2>
      <div class="content">
        <p><b>Register Account</b></p>
        <p>By creating an account you will be able to shop faster, be up to date on an order's status, and keep track of the orders you have previously made.</p>
        <br />
        <a href="register.jsp" class="button"><span>Continue</span></a></div>
    </div>
    <div class="right">
      <h2>Returning Customer</h2>
      <form name="loginForm" action="UserLoginS" method="post" onsubmit="return checkinput()" id="login">
        <div class="content">
          <p>I am a returning customer</p>
          <b>User Name:</b><br />
          <input type="text" id="username" value="" name="username"/>
          <br />
          <br />
          <b>Password:</b><br />
          <input type="password" id="password" value="" name="password" />
          <br />
          <br />
          <input type="Submit"  name="submit" value="Login" />
		  <input type="Reset" name="reset" style="width: 50px" value="Reset" />
                  </div>
      </form>
    </div>
  </div>
  </div>
  
</div>


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
		<p>A group of Computer Science major student from University of Florida developing a website implementing Oracle database. </p>
        <p>The group includes: Liu Zhengzheng, Xu Yufan, Wang Xi, Jiang Li</p>
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
<div class="clearfix"></div>
		</div>

</div>
</div>

</body>
</html>