<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set value="${pageContext.request.contextPath }" var="contextPath"></c:set>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="${contextPath }/vendor/profile">Profile</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/vendor/editprofile">Edit Profile</a>
    </li>
    <li class="nav-item">
    	<a class="nav-link" href="${contextPath }/vendor/category">Add Products</a>
    </li>
     <li class="nav-item">
    	<a class="nav-link" href="${contextPath }/vendor/productdetails">View Products</a>
    </li>
     <li class="nav-item">
    	<a class="nav-link" href="/">Home page</a>
    </li>
   </ul>
 </nav>
</body>
</html>