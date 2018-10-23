<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">
<link rel="stylesheet"
    href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
    integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
    crossorigin="anonymous">
<script
    src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
    integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
    crossorigin="anonymous"></script>
<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
    integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>
<script
    src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
    integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
    crossorigin="anonymous"></script>
</head>
<body>
 <%-- <div class="row">
<spring:form action="customer/customerloginprocess" type="POST" modelAttribute="customer">
<table>
 <tr>
 	<td><label>Email</label></td>
	<td><spring:input path="customer_email"/></td>
</tr>

<tr>

	<td><label>Password</label></td>
	<td><spring:input type="password" path="customer_password"/></td>
</tr>

</table>
<tr>
<td colspan="2"><input type="submit" class="btn" value="Submit"></td>
<tr> 
</spring:form> 	 
</div> --%>
<div class="bg">
<div id="login-box">
	<h2>Login with Email and Password</h2>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
<%-- <form name='loginForm'
		  action="customer/customerloginprocess"  method='POST'>
		  <h2>Login with Email and Password</h2>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
 <table>
 <tr>
 	<td><label>Email</label></td>
	<td><input type="text" name="customer_email"/></td>
</tr>
<tr>

	<td><label>Password</label></td>
	<td><input type="password" name="customer_password"/></td>
</tr>
<tr>
	<td colspan="2"><input type="submit" class="btn" value="Submit"></td>
</tr>
</table>
</form>
 --%><form action="customer/customerloginprocess" method='POST'>
    <div class="form-group">
      <label for="email">Name:</label>
      <input type="text" class="form-control" id="email" name="customer_email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" name="customer_password">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>
</div>

</body>
</html>
<style>
.bg {
         background-image: url(http://redpithemes.com/Documentation/assets/img/page_bg/page_bg_blur02.jpg);
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