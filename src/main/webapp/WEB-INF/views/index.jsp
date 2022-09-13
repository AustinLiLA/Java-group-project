<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
     
     <h1> Welcome to Trading Platform</h1>
     
     <form action="http://localhost:8080/order-book-group-a/CustomerMappingController">
	 
	 

     Email ID : <input type="text" name="Email" /> <br>
     
     Password : <input type="password" name="Password"/> <br>
     
     <input type="submit" value="Login"/> 

   

     </form>
     
     
     New Customer? <a href="registration.jsp">Click here to register</a>
     <br>
   
</body>
</html>