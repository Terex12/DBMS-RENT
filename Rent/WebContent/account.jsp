<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.*" import="java.util.*" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<%
	UserInfo u = (UserInfo) session.getAttribute("userinfo");
	LinkedList<Integer> ol = (LinkedList<Integer>)request.getAttribute("orderinfo");
%>

<link rel="stylesheet" type="text/css" href="./CSS/css.css" />
<title>iCart HTML Version</title>
</head>
<body>
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
<li><a href="account.jsp" class="account">My Account</a></li>
<li><a href="shoppingcart.jsp" class="cart">Shopping Cart</a></li>
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
      <li><a href="#">My Account</a></li>
      <li><a href="#">Returns</a></li>
      <li><a href="#">Transactions</a></li>
      <li><a href="#">Newsletter</a></li>
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
				<table border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
					<tr>
						<td height="25">
							User Name						
						</td>
						<td>
							Real Name
						</td>
						<td>
							Address
						</td>
						<td>
							Email
						</td>
					</tr>
					<tr>
						<td height="25" bgcolor="#FFFFFF">
							<%=u.getUserName()%>					</td>
						<td bgcolor="#FFFFFF">
							<%=u.getName()%>					  </td>
						<td bgcolor="#FFFFFF">
							<%=u.getAddress()%>					  </td>
						<td bgcolor="#FFFFFF">
							<%=u.getEmail()%>					  </td>
					</tr>
			  </table>
    </div>
    <div class="right">
      <h2>Returning Customer</h2>
      		<form action="OrderS?flag=1" method="post">
			
			<div align="center">
				<table border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
					<tr>
						<td height="25">
							Order						
						</td>
					</tr>
					<%
					for (Integer oid : ol) {
					%>
				<tr>
					<td height="25" bgcolor="#FFFFFF"><a href="OrderS?flag=2&oid=<%=oid%>"><%=oid%></a></td>
				</tr>
				<%
					}
				%>
					
			  </table>
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



