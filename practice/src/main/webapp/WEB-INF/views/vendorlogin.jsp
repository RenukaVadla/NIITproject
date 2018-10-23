
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

  
<title>Insert title here</title>
</head>
<body>
<div class="bg">
  <div class="container-fluid bg">
                <div class="row">
                 
<div id="login-box">
	<h2 style="text-align:center;">Login with Username and Password</h2>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
<!-- <form name='loginForm'
		  action="vendor/vendorloginprocess"  method='POST'>
 <table>
 <tr>
 	<td><label>Email</label></td>
	<td><input type="text" name="vendor_email"/></td>
</tr>
<tr>

	<td><label>Password</label></td>
	<td><input type="password" name="vendor_password"/></td>
</tr>
<tr>
	<td colspan="2"><input type="submit" class="btn" value="Submit"></td>
</tr>
</table>
</form>
 -->

 
 
 <form action="vendor/vendorloginprocess" method='POST'>
    <div class="form-group">
      <label for="email">Name:</label>
      <input type="text" class="form-control" id="email" name="vendor_email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" name="vendor_password">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>
</div>
</div>
</div>
</body>
</html>

<style>
.bg {
         background-image: url(https://images.unsplash.com/photo-1508615039623-a25605d2b022?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=7d106299bf1c34b2f367f2280c67a80a&auto=format&fit=crop&w=1500&q=80);
             width: 100%;
          height: 100vh; 
           background-position: center;
           background-repeat: no-repeat;
           background-size: cover;
   }
form
       {
           padding-left: 550px;
           padding-bottom: 60px;
       }
</style>