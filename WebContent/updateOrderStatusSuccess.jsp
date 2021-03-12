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
	
	<h4>Customer Order Status Has Been Updated.</h4>
	<h4>Auto Redirecting Back to Customer Update Order Status Page.</h4>
	
	<a href='UpdateCustOrderStatus.jsp'>Click Here if not redirecting back automatically.</a>
	<%
		int timeout = 3;
		
		session.removeAttribute("ORDERLIST");
		session.removeAttribute("CUSTLIST");
		response.setHeader("Refresh", timeout + "; URL = UpdateCustOrderStatus.jsp");	
		
	%>
	
	<jsp:include page="includes/Footer.jsp" />
</body>
</html>