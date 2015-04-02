<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" import="bean.*"%>>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
	LinkedList<OrderInfo> order = (LinkedList<OrderInfo>) request.getAttribute("order");
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rate your Purchase</title>
</head>
<body>
<form action="OrderS?flag=3" method="post">
<table width="600" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
				<tr>
					<td height="25">
						<div align="center">Product Name			</div></td>
					<td>
						<div align="center">Price					</div></td>
					<td>
						<div align="center">Amount					</div></td>
					<td>
						<div align="center">Rate					</div></td>
					
				</tr>
				<%
						for (OrderInfo oi : order) {
					%>
					<tr>
						<td height="25" bgcolor="#FFFFFF">
							<%=oi.getProname()%>					  </td>
						<td bgcolor="#FFFFFF">
							<%=oi.getPrice()%>					  </td>
						<td bgcolor="#FFFFFF">
							<%=oi.getQuantity()%>" 				  </td>
						<td> 
						<input type="radio" name="rate" value="1" /> 1
						<input type="radio" name="rate" value="2" /> 2
						<input type="radio" name="rate" value="3" /> 3
						<input type="radio" name="rate" value="4" /> 4
						<input type="radio" name="rate" value="5" /> 5
						</td>
					
					<%
						}
					%>
						
					</tr>
</table>
 <input type="submit" value="rate" />		
</form>		  


</body>
</html>