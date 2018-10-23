<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:url value="/resource/resource/" var="image"></c:url>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
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
<c:set value="${pageContext.request.contextPath }" var="contextPath"></c:set>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
  <li class="nav-item active">
    <a class="nav-link" href="${contextPath }/vendor/vendor">Home</a>
    </li>
    <li class="nav-item ">
      <a class="nav-link" href="${contextPath }/vendor/profile">Profile</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/vendor/editprofile">Edit Profile</a>
    </li>
    <li class="nav-item">
    	<a class="nav-link" href="${contextPath }/vendor/category">Add Products</a>
    </li>
     
       <%--<li class="nav-item" >
    	<a class="nav-link "  href="${contextPath }/">Log Out</a>
    </li> --%>
   </ul>

   <ul class="nav justify-content-end">
        <li><a class="nav-link "  href="${contextPath }/">Log Out</a></li>
    </ul>
 
 </nav>
  <div class="bg">
	<div class="container">
		<div class="row">
			<c:forEach items="${productList}" var="product">
				<div class="col-md-4">
					<div class="thumbnail">
						<img
							src="<spring:url  value='/resources/resource/products/${product.product_id}.jpg'></spring:url>"
							alt="${product.product_brand }" style="width: 100%" />

						<div class="caption">

							<a href="viewproduct/${product.product_id }"><button class="btn btn-primary">view</button></a> 
							<a href="editproduct/${product.product_id }"><button class="btn btn-success">Edit</button></a>

						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
</body>
</html>
