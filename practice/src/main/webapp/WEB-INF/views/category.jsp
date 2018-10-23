<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:set value="${pageContext.request.contextPath }" var="contextPath"></c:set>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav active">
  <li class="nav-item ">
      <a class="nav-link" href="${contextPath }/vendor/vendor">Home</a>
    </li>
  </ul>
  <ul class="nav justify-content-end">
        <li><a class="nav-link "  href="${contextPath }/">Log Out</a></li>
    </ul>
  
</nav>
<li class="nav-item dropdown"><a
		class="nav-link dropdown-toggle text-danger" href="#" id="navbardrop"
		data-toggle="dropdown">Categories</a>
		<div class="dropdown-menu">
			<c:forEach items="${categoryList}" var="category">
				<a class="dropdown-item" href="${contextPath}/vendor/subcategory/${category.categoryId}">${category.categoryName}</a>
			</c:forEach>
		</div></li>

</body>
</html>