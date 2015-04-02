<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.*" import="java.util.*" %>
<!DOCTYPE html>
<html>
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
		<title>Shopping Cart</title>
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
		<style type="text/css">
<!--
.STYLE1 {
	font-size: 12px
}
-->
</style>
	</head>
<link type="text/css" rel="stylesheet" href="CSS/style.css">
	<body>
		<h1 align="center">Shopping Cart</h1>
		<div align="center">
			<table>
				<tr>
					<td width="608">
						<span class="STYLE1">
						<%
							if (cart.size() == 0) {
						%> 		Shopping Cart is Empty! <a href="ProductS?flag=0&&keyword=<%=keyword%>">Go to Shopping</a><%
							} else {
						%> Shopping Cart </span>
				  	</td>
					<td width="51">
						<a href="UserLogOutS" class="STYLE1">Log Out</a>					
					</td>
				</tr>
			</table>
		</div>
		<form action="CartS?flag=1" method="post">
			<div align="center">
				<table width="600" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
					<tr>
						<td height="25">
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
					</tr>
					<%
						for (int i = start; i < end; i++) {
								CartInfo c = cart.get(i);
					%>
					<tr>
						<td height="25" bgcolor="#FFFFFF">
							<%=c.getProductName()%>					  </td>
						<td bgcolor="#FFFFFF">
							<%=c.getPrice()%>					  </td>
						<td bgcolor="#FFFFFF">
							<input type="text" value="<%=c.getQuantity()%>" name="num"
								onblur="numAbove(this)" />					  </td>
						<td bgcolor="#FFFFFF">
							<%=c.getQuantity() * c.getPrice()%>					  </td>
						<td bgcolor="#FFFFFF">
							<a href="CartS?flag=3&id=<%=c.getId()%>">Delete</a>						</td>
					</tr>
					<%
						}
					%>
			  </table>
				<table width="600" bgcolor="#999999">
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
						<td width="108">
							<a href="CartS?flag=2&&keyword=<%=keyword%>">Clear Shopping Cart</a>
						</td>
						<td width="132">
							<a href="ProductS?flag=0&&keyword=<%=keyword%>">Continue Shopping</a>
						</td>
						<td width="132">
							<a href="orderreview.jsp">Place Order</a>
						</td>
					</tr>
				</table>
			</div>
			
			<div>
				<div align="center">
					<ul>
						<span class="STYLE1"><a href="shoppingcart.jsp?page=1">Pre Page</a> <%
 	for (int i = 1; i <= allPage; i++) {
 			if (i == currentPage) {
 			%><%=i%> 
 			<%
 				} else {
 			%> <a href="shoppingcart.jsp?page=<%=i%>"><%=i%></a> 
 			<%
 				}
 			}	
 		%> 
 	<a href="shoppingcart.jsp?page=<%=allPage%>">Next Page</a> </span>
						
					</ul>
				</div>
			</div>
		</form>
		<div align="center">
			<span class="STYLE1"> 
			<%
				}
			%> </span>
		</div>
	</body>
</html>