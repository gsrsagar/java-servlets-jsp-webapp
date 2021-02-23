<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registering New products</title>
 <style>
 #d1{
  color:#541115;
 }
 input{ border:1px solid #541115;
        background-color:white;
        border-radius:3px; C:\Sagar_workspace\eclipse_workspace\EnterpriseProject\WebContent\images
       
  
 }
 body{
  background-color:#7D6E47;
   //background:url(images/image.jpg);
   
   background-repeat:no-repeat;
 // width:100%;
  //height:100%;
   background-size: cover;
 
 
 }
 form{
     margin-left:auto;
     margin-right:auto;
     display:block;
     //margin-top:15%;
     margin-bottom:0%;
}
 label{
    font-size:20px;
    font-family:calibri;
    color:white;
    
 }
 </style>

</head>
<body>
<% 	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");  //http:1.1
response.setHeader("pragma","no-cache");  // 1.0
response.setHeader("Expires", "0"); %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="p" value="${requestScope.p}"/>

<form action="AddProductServlet">
<b><span style="font-family:calibri;text-align:center;color:#541115">Update the Existing Product</span></b><br/><br/>
<label>product id:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="pid" value="<c:out value='${p.pid}'/>" readonly /><br/><br/>
<label>product name:</label><input type="text" name="pname" value="<c:out value='${p.pname}'/>"/><br/><br/>
<label>Cost:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="cost" value="<c:out value='${p.cost}'/>"/><br/><br/>
<label>Quantity:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="quantity" value="<c:out value='${p.quantity}'/>"/><br/><br/>
<input style="color:#541115;padding:8px;font-weight:bolder;border-radius:5px;" type="submit" value="add">
</form>


<%-- <c:if test="${empty p}">
<b><span style="font-family:calibri;text-align:center;color:#541115">Register a new Product</span></b>
<form action="AddProductServlet"><br/>
<label >Product name:</label><input type="text" name="pname" /><br/><br/>&nbsp;
<label>Cost:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="cost" /><br/><br/>
<label>quantity:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="quantity"/><br/><br/>
<input style="color:#541115;padding:8px;font-weight:bolder;border-radius:5px;"type="submit" value="register">
</form>
</c:if> --%>
 

</body>
</html>