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
<title>Product</title>
</head>
<link type="text/css" rel="stylesheet" href="CSS/style.css">
	<body>
	<h1 align="center">Product</h1>
		<div align="left" class="STYLE1"> 
		  <div align="center">User Name: <%=u.getName()%></div>
		</div>
		<form action="CartS?flag=0&proid=<%=pd.getProId()%>" method="post">
		  <div>
			  <table border="1" align="center" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
			    <tr>
			      <td rowspan="5">
			        <img src="PIC/<%=pd.getPic()%>" />			        </td>
				    <td bordercolor="#FFFFFF" bgcolor="#FFFFFF">
					    Product Name
					    <%=pd.getProName()%>			        </td>
			    </tr>
			    <tr>
			      <td bordercolor="#FFFFFF" bgcolor="#FFFFFF">
			        Price
			        <%=pd.getPrice()%>			        </td>
			    </tr>
			    <tr>
			      <td bordercolor="#FFFFFF" bgcolor="#FFFFFF">
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
	</body>
</html>

