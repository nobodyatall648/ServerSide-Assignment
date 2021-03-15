<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="includes/HeaderCustomer.jsp" />


	<h2>
		<strong>Add Product</strong>
	</h2>
	
	<form action="./InsertData" method="post"> 
	
        <p>Product Code:</p>  
        <input type="text" name="id"/> 
        <br/>
         
        <p>Product Name:</p>  
        <input type="text" name="string"/> 
        <br/>
        
        <p>Product Line:</p>  
        <input type="text" name="id"/> 
        <br/>
        
        <p>Product Scale:</p>  
        <input type="text" name="id"/> 
        <br/>
        
        <p>Product Vendor:</p>  
        <input type="text" name="id"/> 
        <br/>
        
        <p>Product Description:</p>  
        <input type="text" name="id"/> 
        <br/>
        
        <p>Product Quantity:</p>  
        <input type="text" name="id"/> 
        <br/>
        
        <p>Product Price:</p>  
        <input type="text" name="id"/> 
        <br/>
        
        <p>Product Msrp:</p>  
        <input type="text" name="id"/> 
        <br/>
        
        <br/>
        <input type="submit"/> 
    </form> 
    
    <jsp:include page="includes/Footer.jsp" />
</body>
</html>