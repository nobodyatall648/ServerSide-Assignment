<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Management</title>

</head>
<body>
	<jsp:include page="includes/HeaderAdmin.jsp" />
	<div class="container">
		<h1><u>Employee Section</u></h1>
		<h1>Update and Delete Employee</h1>
		<form method="post" action="ViewEmployee">
			Please enter specific Employee Number to view their detail for delete
			and update. <br> <br> <label for="uname"><b>Employee
					Number: </b></label> <input type="text" placeholder="EmployeeNumber"
				name="employeenum" required>

			<button class="buttondesignemp" type="submit">Submit</button>
		</form>
		<%
		//get fail search for employee num
		try {
			if (request.getParameter("fail") == null) {

			} else {
				out.println("<br><div class='text-danger'>Failed to search for employee number. Please try again.</div>");
			}
		} catch (Exception e) {

		}
		%>
		<br> 
		<hr>
		<div class="form-popup" id="myForm">
			<form action="admincontroller" class="form-container" method="post">
				<h1>Add Employee</h1>

				Please enter Employee Details to add Employee.  <br> <br>
				<table class="table">
 					<tr> 
 						<th>Employee Number</th> 
 						<td><input type="text" name="id" required/></td>
 					</tr> 
					<tr>
						<th>First Name</th>
						<td><input type="text" name="fname" required/></td>
					</tr>
					<tr>
						<th>Last Name</th>
						<td><input type="text" name="lname" required/></td>
					</tr>
					<tr>
						<th>Email</th>
						<td><input type="text" name="email" required/></td>
					</tr>
					<tr>
						<th>Office Code</th>
						<td><input type="text" name="officecode" required/></td>
					</tr>
					<tr>
						<th>Report</th>
						<td><input type="text" name="report" required/></td>
					</tr>
					<tr>
						<th>Job</th>
						<td><input type="text" name="job" required/></td>
					</tr>
				</table>
				<button class="buttondesignemp" type="submit">Submit</button>
				<button class="buttondesignemp" type="reset">Reset</button>
			</form>
		</div>

	</div>
	<br><br><br>
	<jsp:include page="includes/Footer.jsp" />
</body>
</html>