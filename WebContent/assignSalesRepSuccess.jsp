<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assign SalesRep Success</title>
</head>
<body>
	<jsp:include page="includes/HeaderEmployee.jsp" />
	
	<h4>Customer Order Status Has Been Assigned a Sales Representative.</h4>
	<h4>Auto Redirecting Back to Customer Handling & Assigning Page.</h4>
	
	<a href='GetUnassignedSRCust'>Click Here if not redirecting back automatically.</a>
	<%
		int timeout = 3;
		response.setHeader("Refresh", timeout + "; URL = GetUnassignedSRCust");		
	%>
	
	<jsp:include page="includes/Footer.jsp" />
</body>
</html>