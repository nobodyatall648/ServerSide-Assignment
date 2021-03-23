<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Management</title>
<style>
.form-container .btn:hover, .open-button:hover {
	opacity: 1;
}
.form-popup {
	overflow-x: hidden;
	overflow-y: auto;
	height: 400px;
	display: none;
	position: fixed;
	top: 60%;
	left: 50%;
	-webkit-transform: translate(-50%, -50%);
	transform: translate(-50%, -50%);
}

/* Add styles to the form container */
.form-container {
	max-width: 500px;
	padding: 10px;
	background-color: white;
}
.form-container .btn {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	border: none;
	cursor: pointer;
	width: 100%;
	margin-bottom: 10px;
	opacity: 0.8;
}
</style>
</head>


<body>
<jsp:include page="includes/HeaderAdmin.jsp" />

<h1>Office Section</h1>
<br>
<h1>Please refer database to include data</h1>

	
	<h1>Office Section</h1>
<form method="post" action="OfficeController">
  

  <div class="container">
  Please Enter Specific Office Detail to add office.
  <br>
  <br>
    <label ><b>City</b></label>
    <input type="text" placeholder="City" name="city" required>
    <br>
    <label ><b>Phone</b></label>
    <input type="text" placeholder="phone" name="phone" required>
    <br>
    <label ><b>Address line 1</b></label>
    <input type="text" placeholder="address 1" name="add1" required>
    <br>
    <label ><b>Address line 2</b></label>
    <input type="text" placeholder="address 2" name="add2" required>
    <br>
    <label ><b>State</b></label>
    <input type="text" placeholder="State" name="state" required>
    <br>
    <label ><b>Country</b></label>
    <input type="text" placeholder="Country" name="country" required>
    <br>
    <label ><b>Postal Code</b></label>
    <input type="text" placeholder="Postal Code" name="pcode" required>
    <br>
    <label ><b>Territory</b></label>
    <input type="text" placeholder="Territory" name="territory" required>
    <br>
    <button type="submit">Submit</button>
  </div>

</form>

<br>
<br>
<h1>Office Updating and Deleting</h1>
<form method="get" action="OfficeController">
  

  <div class="container">
  Please Enter Office Code to view Detail.
  <br>
  <br>
    <label for="uname"><b>Office Code</b></label>
    <input type="text" placeholder="Office Code" name="ocode" required>
    
    <button type="submit">Submit</button>
  </div>

</form>
<br>
	

<jsp:include page="includes/Footer.jsp" />
</body>
</html>