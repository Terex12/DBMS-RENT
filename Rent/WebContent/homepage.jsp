<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="dao.ProductDao" import="bean.*" import="util.PageList" import="java.util.*"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	<%
  		LinkedList<ProductInfo> l = (LinkedList<ProductInfo>)request.getAttribute("findAllGoods");
		UserInfo u = (UserInfo) session.getAttribute("userinfo");
		PageList pl = (PageList) request.getAttribute("page");
  		String keyword = (String)session.getAttribute("keyword"); 
	%>
<title>Home Page</title>
</head> 
<link type="text/css" rel="stylesheet" href="CSS/style.css">
<body>  
	<h1 align="center">Product Show</h1>
	
		<div align="center">
			<table width="600" height="30">
				<tr>
					<td width="456">
						<span class="STYLE1"> User Name<%=u.getName()%></span>
				  	</td>
					<td width="56">
						<a href="UserLogOutS" class="STYLE1">Log Out</a>					</td>
					<td width="72" align="right">
						<a href="shoppingcart.jsp?keyword=<%=keyword%>" class="STYLE1">check Shopping cart</a>					</td>
					<td width="72" align="right">
						<a href="OrderS?flag=1" class="STYLE1">View Account</a>					</td>
					<td width="72" align="right">
						<a href= "searchwelcom.jsp">back to search</a>				</td>
						
				</tr>
			</table>
			
			<table width="600" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
				<tr>
					<td height="25">
						<div align="center">Product Name			</div></td>
					<td>
						<div align="center">Price					</div></td>
					<td>
						<div align="center">Stock					</div></td>
					<td>
						<div align="center">PIC					</div></td>
					
				</tr>
				<%
					for (ProductInfo pro : l) {
				%>
				<tr>
					<td height="25" bgcolor="#FFFFFF"><a href="ProductS?flag=1&proid=<%=pro.getProId()%>"><%=pro.getProName()%></a></td>
					<td bgcolor="#FFFFFF">
					<%=pro.getPrice()%>					</td>
					<td bgcolor="#FFFFFF">
					<%=pro.getStock()%>					</td>
					<td bgcolor="#FFFFFF">
					<img src="PIC/<%=pro.getPic()%>" />	</td>
				</tr>
				<%
					}
				%>
		  </table>
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
	</body>
</html>