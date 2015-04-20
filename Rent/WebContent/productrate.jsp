<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" import="bean.*"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<%
	OrderInfo item = (OrderInfo) request.getAttribute("singleProduct");
	session.setAttribute("singleProduct", item);
%>
<link rel="stylesheet" type="text/css" href="./CSS/css.css" />
<title>GatorRental HTML Version</title>
</head>
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
<div id="content">  
<form action="OrderS?flag=3" method="post">
  <div class="wishlist-product" align="center">
		<table style="min-height:150px; height:150px; width:80%">
		<tr>
					<td>
						Product Name</td>
					<td>
						Price</td>
					<td>
						Amount</td>
					<td>
						Rate</td>
					
				</tr>
				<tr>
						<td>
							<%=item.getProid()%>					  </td>
						<td>
							<%=item.getPrice()%>					  </td>
						<td>
							<%=item.getQuantity()%> 				  </td>
						<td> 
						<input type="radio" name="rate" value="1" /> 1
						<input type="radio" name="rate" value="2" /> 2
						<input type="radio" name="rate" value="3" /> 3
						<input type="radio" name="rate" value="4" /> 4
						<input type="radio" name="rate" value="5" /> 5
						</td>
					
						
					</tr>
		</table>
		 <input type="submit" value="rate" />	
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