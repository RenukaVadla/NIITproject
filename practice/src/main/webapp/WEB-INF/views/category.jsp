<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="subcategory" method="post">
       <div class="form-group">
           <label for="sel1">Categories</label>
            <select class="form-control " id="category" name="category">
               <c:forEach items="${categoryList}" var="category">
               
               <option value="${category.categoryId }">${category.categoryName }</option>

               </c:forEach>
           </select>
       </div>
       <input type="submit" class="btn" value="Submit">
</form>
</body>
</html>