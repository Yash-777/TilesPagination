<%@ page language="java" contentType="text/html; charset=ISO-8859-1"   pageEncoding="ISO-8859-1"%>
<%@ page import="java.net.InetAddress" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Displays Client IP Address</title>
</head>
<body>
<%
	String current = request.getRemoteAddr();
	if (current.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
		InetAddress inetAddress = InetAddress.getLocalHost();
		String ipAddress = inetAddress.getHostAddress();
		current = ipAddress;
	}
out.println("<br><B>Clients IP : </B>"+current);
%>
<span><br>Local Host  : <%= request.getRemoteAddr() %></span>
<span><br>ServerPort  : <%= request.getServerPort() %></span>
<span><br>Application : <%= request.getContextPath() %></span>
<span><br>Path		  : <%= request.getRequestURI()%></span>
<span><br>Header      : <%= request.getHeader("X-Forwarded-For") %></span>
</body>
</html>