<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.*" %>
<!DOCTYPE html>
<html>
<head>
<%
	ProductInfo pd = (ProductInfo) request.getAttribute("product");
	UserInfo u = (UserInfo) session.getAttribute("userinfo");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./CSS/css.css" />
<title>iCart HTML Version</title>
</head>
<body>
<div class="menu">
<ul>
<li style="width:0px;"><a></a></li>
<li><a href="search.jsp" class="home">Home</a></li>
<li><a href="account.html" class="account">My Account</a></li>
<li><a href="cat.html" class="cart">Shopping Cart</a></li>
<li><a href="cart.html" class="checkout">Checkout</a></li>
<li style="float:right;"><a href="login.html" class="login">Login/Register</a></li>
<!--<li style="float:right;"><a class="register">Register</a></li>-->
</ul>
</div>


<div class="header">
<div class="logo_img"><a href="index.html"><img src="images/Florida_Gators_script_logo.png" alt="Site Name" width="200" height="60"></a></div></div>

<div id="menu">
</div>




<div style="width:1000px;margin: 0 auto;margin-top:10px;">
<div class="linktree">
        <a href="#">Home</a>
         &raquo; <a href="#">iMac</a>
    </div>

  <h1 style="margin-top:-10px;">iMac</h1>
</div>
<div id="container_bg">
<div id="content">
		<form action="CartS?flag=0&proid=<%=pd.getProId()%>" method="post">
		  <div>
			  <table>
			    <tr>
			      <td >
			        <img src="PIC/<%=pd.getPic()%>" />			        </td>
				    <td>
					    Product Name
					    <%=pd.getProName()%>			        </td>
			    </tr>
			    <tr>
			      <td>
			        Price
			        <%=pd.getPrice()%>			        </td>
			    </tr>
			    <tr>
			      <td>
			       Stock
			        <%=pd.getStock()%>			        </td>
			    </tr>
			    <tr>
			      <td align="right">
			        <input type="submit" value="Add to Cart" />			       
					 <input type="button" value="back" onClick="javascript:history.go(-1)"/>			        
					</td>
			    </tr>
			    
            </table>
		  </div>
		</form>
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
