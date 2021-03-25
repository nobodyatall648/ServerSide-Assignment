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
		<h1>
			<u>Office Section</u>
		</h1>
		
		<h1>Update and Delete Office</h1>
		<form method="get" action="OfficeController">
				Please enter Office Code to update or delete office. <br> <br> <label
					for="uname"><b>Office Code: </b></label> <input type="text"
					placeholder="Office Code" name="ocode" required>

				<button class="buttondesign" type="submit">Submit</button>
		</form>
		<%
		//get fail search for office code
		try {
			if (request.getParameter("fail") == null) {

			} else {
				out.println("<br><div class='text-danger'>Failed to search for office code. Please try again.</div>");
			}
		} catch (Exception e) {

		}
		%>
		<br>
		<hr>
		<h1>Add Office</h1>
		<form method="post" action="OfficeController">
			Please Enter Specific Office Detail to add office. <br> <br>
			<table class="table">
				<tr>
					<th>City</th>
					<td><input type="text" placeholder="City" name="city" required></td>
				</tr>
				<tr>
					<th>Phone</th>
					<td><input type="text" placeholder="phone" name="phone"
						required></td>
				</tr>
				<tr>
					<th>Address line 1</th>
					<td><input type="text" placeholder="address 1" name="add1"
						required></td>
				</tr>
				<tr>
					<th><b>Address line 2</b></th>
					<td><input type="text" placeholder="address 2" name="add2"
						required></td>
				</tr>
				<tr>
					<th><b>State</b></th>
					<td><input type="text" placeholder="State" name="state"
						required></td>
				</tr>
				<tr>
					<th><b>Country</b></th>
					<td><input type="text" placeholder="Country" name="country"
						required></td>
				</tr>
				<tr>
					<th><b>Postal Code</b></th>
					<td><input type="text" placeholder="Postal Code" name="pcode"
						required></td>
				</tr>
				<tr>
					<th><b>Territory</b></th>
					<td><input type="text" placeholder="Territory"
						name="territory" required></td>
				</tr>
			</table>
			<button class="buttondesign" type="submit">Submit</button>
			<button class="buttondesign" type="reset">Reset</button>
		</form>
	</div>
	<br>
	<br>
	<jsp:include page="includes/Footer.jsp" />
</body>
</html>