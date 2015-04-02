<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="bean.*" import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	UserInfo u = (UserInfo) session.getAttribute("userinfo");
	LinkedList<Integer> ol = (LinkedList<Integer>)request.getAttribute("orderinfo");
%>
<title>User Account</title>
</head>
<link type="text/css" rel="stylesheet" href="CSS/style.css">
<body>
	    <h1 align="center">User Account</h2>
		<form action="OrderS?flag=1" method="post">
			<div align="center">
				<table border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
					<tr>
						<td height="25">
							User Name						
						</td>
						<td>
							Real Name
						</td>
						<td>
							Address
						</td>
						<td>
							Email
						</td>
					</tr>
					<tr>
						<td height="25" bgcolor="#FFFFFF">
							<%=u.getUserName()%>					</td>
						<td bgcolor="#FFFFFF">
							<%=u.getName()%>					  </td>
						<td bgcolor="#FFFFFF">
							<%=u.getAddress()%>					  </td>
						<td bgcolor="#FFFFFF">
							<%=u.getEmail()%>					  </td>
					</tr>
			  </table>
			</div>
			
			<div align="center">
				<table border="1" cellpadding="1" cellspacing="1" bordercolor="#FFFFFF" bgcolor="#CCCCCC">
					<tr>
						<td height="25">
							Order						
						</td>
					</tr>
					<%
					for (Integer oid : ol) {
					%>
				<tr>
					<td height="25" bgcolor="#FFFFFF"><a href="OrderS?flag=2&oid=<%=oid%>"><%=oid%></a></td>
				</tr>
				<%
					}
				%>
					
			  </table>
			</div>
			
			
		</form>
	</body>
</html>