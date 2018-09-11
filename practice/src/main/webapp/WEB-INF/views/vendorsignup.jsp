<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
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
    <div class="bg">
            <div class="container-fluid bg">
                <div class="row">
                        <springform:form  action="vendorsignup" method="post" modelAttribute="vendor">
            
            <div class="form-group">
            <label for="vendor_name">Name:</label>    
            <springform:input path="vendor_name" class="form-control" id="vendor_name"/>    
            <springform:errors path="vendor_name"></springform:errors>    
            </div>
            
            <div class="form-group">
            <label for="company_name">Company:</label>    
            <springform:input path="company_name" class="form-control" id="company_name"/>        
            </div>    
            
            <div class="form-group">
            <label for="vendor_mobile">Mobile:</label>    
            <springform:input path="vendor_mobile" class="form-control" id="vendor_mobile"/>        
            </div>    
            
            
            <div class="form-group">
            <label for="vendor_emaill">Email Id:</label>
            <springform:input path="vendor_email" class="form-control" id="vendor_email"/>
            </div>
            
            
            <div class="form-group">
            <label for="vendor_password">Password:</label>    
            <springform:input path="vendor_password" class="form-control" id="vendor_password"/>        
            </div>
            
            <div class="form-group">
            <label for="cofirmpassword">Confirm Password:</label>    
            <springform:input path="cofirmpassword" class="form-control" id="cofirmpassword"/>        
            </div>
            

       <%--  <td><springform:label path="role">Role:</springform:label></td>
        <td>
        <ul>
            <springform:select path="role">
                <springform:option value="vendor">Vendor</springform:option>
                <springform:option value="customer">Customer</springform:option>
                <springform:option value="admin">Admin</springform:option>
            </springform:select>
        
        </ul>
        </td> --%>
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




<style>
.bg {
         background-image: url(https://blitzen.com/blog/wp-content/uploads/new-tech.jpg);
             width: 100%;
          /*  height: 100vh; */
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












