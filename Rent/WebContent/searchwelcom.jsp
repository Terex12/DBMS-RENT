<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="dao.ProductDao" import="bean.*" import="util.PageList" import="java.util.*"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
 	LinkedList<ProductInfo> l = (LinkedList<ProductInfo>)request.getAttribute("findAllGoods");
	UserInfo u = (UserInfo) session.getAttribute("userinfo");
	PageList pl = (PageList) request.getAttribute("page");
%>

<title>Search</title>
</head>
<body>
<%
if(session.getAttribute("userinfo")==null)
{%>
<h1>You are not login, Please Login first</h1>
It will redirect in 3 seconds
<p>
if not auto redirect,please click<a href="login.jsp">here</a></p>
<%
response.setHeader("refresh","3;URL=login.jsp");
return;
}
%>
<h1>Input what your want</h1>

<form action="SearchS" method="post">
<input type="text" name="search" width="150px">
<br>

<input type="submit" value= "search" name="submit" />


<!-- 静态的加入分类名称 -->
<table width="600" border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">			
<tr>
	<td bgcolor="#FFFFFF">
		<a href="CategoryS?catename=<%="fabric"%>">Fabric</a>						
	</td>
</tr>						
					
					
</table>



</form>
</body>
</html>