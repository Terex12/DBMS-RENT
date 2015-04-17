<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.ProductDao" import="bean.*" import="util.PageList" import="java.util.*"%> 
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<link rel="stylesheet" type="text/css" href="./CSS/css.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	<%
  		LinkedList<ProductInfo> l = (LinkedList<ProductInfo>)request.getAttribute("findAllGoods");
		UserInfo u = (UserInfo) session.getAttribute("userinfo");
		PageList pl = (PageList) request.getAttribute("page");
  		String keyword = (String)session.getAttribute("keyword"); 
	%>
<title>iCart HTML Version</title>
</head>
<body>
<div class="menu">
<ul>
<li style="width:0px;"><a></a></li>
<li><a href="index.html" class="home">Home</a></li>
<li><a href="OrderS?flag=1" class="account">My Account</a></li>
<li><a href="shoppingcart.jsp?keyword=<%=keyword%>" class="cart">Shopping Cart</a></li>
<li style="float:right;"><a href="login.jsp" class="login">Login</a></li>
</ul>
</div>

<div class="header">
<div class="logo_img"><a href="index.html"><img src="images/Florida_Gators_script_logo.png" alt="Site Name" width="200" height="60"></a></div></div>

<div id="menu">
</div>



<div style="width:1000px;margin: 0 auto;margin-top:10px;">
<div class="linktree">
    
    <a href="#">Home</a>&raquo; <a href="#">Product List</a>



<br>
<h1 style="margin-top:0px;">Product List</h1>

<br>
 
<div id="column-right">
    <div class="box">
  <div class="box-heading_left">Account</div>
  <div class="box-content" style="background:none;border: solid 1px #E3E3E2;"><div class="box-category">
    <ul>
        <li><a href="OrderS?flag=1">My Account</a></li>
      	<li><a href= "search.jsp">Back to Search</a></li>
        <li><a href="UserLogOutS">Logout</a></li>
          </ul>
  </div>
</div>
</div>
</div>
  
  
  
  
  
<div id="content">  
    <div class="wishlist-product">
		<table>
				<tr>
					<td class="image">Image</td>
				    <td class="name">Product Name</td>
				    <td class="price">Unit Price</td>
				    <td class="stock">Stock</td>
				</tr>
				<%
					for (ProductInfo pro : l) {
				%>
				<tr>
					<td class="image">
					<img src="PIC/<%=pro.getPic()%>" />	</td>
					<td class="name"><a href="ProductS?flag=1&proid=<%=pro.getProId()%>"><%=pro.getProName()%></a></td>
					<td class="price">
					<%=pro.getPrice()%>					</td>
					<td class="stock">
					<%=pro.getStock()%>					</td>
					
				</tr>
				<%
					}
				%>
		  </table>
			
			
    </div>
    </div>
    
    <div id="pageList">
			<div align="center">
				<ul>
					<span><a href="ProductS?flag=0&start=1">First Page</a>
						<%
							for (int i = 1; i <= pl.getMaxPage(); i++) {
								if (pl.getCurrentPage() == i) {
						%><%=i%> <%
 							} else {
 						%> <a href="ProductS?flag=0&start=<%=i%>"><%=i%></a> <%
 									}
 							}
 						%> <a href="ProductS?flag=0&start=<%=pl.getMaxPage()%>">Last Page</a> 
 					</span>
				</ul>
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
</div></div>

</body>
</html>
