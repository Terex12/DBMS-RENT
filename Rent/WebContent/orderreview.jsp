<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.*" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
		LinkedList<CartInfo> cart = (LinkedList<CartInfo>) session.getAttribute("Shoppingcart");
		UserInfo u = (UserInfo) session.getAttribute("userinfo");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Review Order</title>
</head>
<body>

<form action="OrderS?flag=1" method="post">
<table width="600" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
				<tr>
					<td height="25">
						<div align="center">Product Name			</div></td>
					<td>
						<div align="center">Price					</div></td>
					<td>
						<div align="center">Amount					</div></td>
					<td>
						<div align="center">Sum					</div></td>
					
				</tr>
				<%
						for (CartInfo c : cart) {
					%>
					<tr>
						<td height="25" bgcolor="#FFFFFF">
							<%=c.getProductName()%>					  </td>
						<td bgcolor="#FFFFFF">
							<%=c.getPrice()%>					  </td>
						<td bgcolor="#FFFFFF">
							<%=c.getQuantity()%>" 				  </td>
						<td bgcolor="#FFFFFF">
							<%=c.getQuantity() * c.getPrice()%>					  </td>
					</tr>
					<%
						}
					%>
</table>

<!-- add the final sum -->

 <input type="submit" value="Make the Order" />		
</form>		  

</body>
</html>