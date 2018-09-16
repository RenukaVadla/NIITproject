<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="bg">
            <div class="container-fluid bg">
                <div class="row">
                        <springform:form  action="customer" method="post" modelAttribute="customer">
            
            <div class="form-group">
            <label for="customer_name">Name:</label>    
            <springform:input path="customer_name" class="form-control" id="customer_name"/>       
            </div>
            
            <div class="form-group">
            <label for="customer_mobile">Mobile:</label>    
            <springform:input path="customer_mobile" class="form-control" id="customer_mobile"/>        
            </div>    
            
            <div class="form-group">
            <label for="customer_emaill">Email Id:</label>
            <springform:input path="customer_email" class="form-control" id="customer_email"/>
            </div>
            
            
            <div class="form-group">
            <label for="customer_password">Password:</label>    
            <springform:input path="customer_password" class="form-control" id="customer_password"/>        
            </div>
            
            <div class="form-group">
            <label for="cofirmpassword">Confirm Password:</label>    
            <springform:input path="cofirmpassword" class="form-control" id="cofirmpassword"/>        
            </div>
            
        <div class="form-group form-check">
            <label class="form-check-label">
            <input class="form-check-input" type="checkbox">Remember Me</label>
        </div>
    <button type="submit" class="btn btn-primary btn-block">Sign Up</button>
</springform:form>
</div>
</div>
</div>

</body>
</html>