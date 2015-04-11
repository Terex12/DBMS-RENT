<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.*" import="java.util.*" %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
		<%
		LinkedList<CartInfo> cart = (LinkedList<CartInfo>) session.getAttribute("Shoppingcart");
		UserInfo u = (UserInfo) session.getAttribute("userinfo");
		String keyword = (String)session.getAttribute("keyword"); 
		Integer currentPage = 0;
		if (request.getParameter("page") == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(request.getParameter("page"));
		}
		Integer allPage = 0;
		if (cart.size() % 10 == 0 && cart.size() != 0){
			allPage = cart.size() / 10;
		}
		else{
			allPage = cart.size() / 10 + 1;
		}
		int start = (currentPage - 1) * 10;
		int end = 0;
		if (cart.size() - start < 10) {
			end = (currentPage - 1) * 10 + cart.size() - start;
		} 
		else {
			end = (currentPage - 1) * 10 + 10;
		}
		%>
		<script type="text/javascript">
			function numAbove(temp){
				var numStr = /^[1-9]+([0-9]){0,3}$/;
				if(!numStr.test(temp.value)){
					alert('Invalid Value');
					temp.focus();
					document.getElementById("submit").disabled = true;
					return false;
				}
				else{
					document.getElementById("submit").disabled = false;
				}
			}
		
		</script>
<link rel="stylesheet" type="text/css" href="./CSS/css.css" />
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
        <a href="#">Home</a>
         &raquo; <a href="#">Shopping Cart</a>
    </div>
<h1 style="margin-top:-10px;">Shopping Cart&nbsp;(20.00kg)</h1>

<br>
     <form action="CartS?flag=1" method="post" id="basket">
      <div class="cart-info">
        <table>
        <tr>
						<td>
							Product Name						
						</td>
						<td>
							Price
						</td>
						<td>
							Amount
						</td>
						<td>
							Sum
						</td>
						<td>
						</td>
					</tr>
					<%
						for (int i = start; i < end; i++) {
								CartInfo c = cart.get(i);
					%>
					<tr>
						<td>
							<%=c.getProductName()%>					  </td>
						<td>
							<%=c.getPrice()%>					  </td>
						<td>
							<input type="text" value="<%=c.getQuantity()%>" name="num"
								onblur="numAbove(this)" />					  </td>
						<td>
							<%=c.getQuantity() * c.getPrice()%>					  </td>
						<td>
							<a href="CartS?flag=3&id=<%=c.getId()%>">Delete</a>						</td>
					</tr>
					<%
						}
					%>
        </table>
        
        <table>
					<tr>
						<td width="102">
							<input type="submit" value= "Change Quantity" name="submit" />
						</td>
						<td width="189">
							<%
								float allCost = 0;
								for (CartInfo c : cart) {
									allCost += c.getQuantity() * c.getPrice();
								}
							%>
							Total Sum:<%=allCost%>
						</td>
						
					</tr>
				</table>
      </div>
    </form>

    <div class="buttons">
      <div class="left"><a href="CartS?flag=2&&keyword=<%=keyword%>" class="button"><span>Clear</span></a></div>
      <div class="right"><a href="ProductS?flag=0&&keyword=<%=keyword%>" class="button"><span>Back</span></a></div>
      <div class="center"><a href="orderreview.jsp" class="button" style="width:120px;"><span>CheckOut</span></a></div>
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
