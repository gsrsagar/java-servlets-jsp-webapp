<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>

<style>
body{
  background-color:#E9C273;
   //background:url(images/image.jpg);
   
   background-repeat:no-repeat;
 // width:100%;
  //height:100%;
   background-size: cover;
 }
  table{
         border-collapse:collapse;  
         background-attachment:fixed;      
    }
    th{  background-color:#541115;
         width:20%;
         padding:10px;
    }
    tr{ 
         padding:10px;
    }
   
    td{ 
     width:18%;
     color:white;
   // background-color:green;
    padding:10px;
    }
    #ab{  
        width: 250px;
        background-color:#541115;
        border:0px solid #541115;
        border-radius:40px;
        color:white;
        border-width:10px;
        border-height:10px;
    }
    li a {
   width: 32px;
   height: 32px;
  color: white;
}
  </style>
  </head>
<body>
<% response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");  //http:1.1
response.setHeader("pragma","no-cache");  // 1.0
response.setHeader("Expires", "0"); %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="menu.html"%>
Logged in as ${sessionScope.sname}
<table>
    <tr>
    <th>Pid</th>
    <th>Pname</th>
    <th>Cost</th>
    <th>Quantity</th>
    <th colspan='2'></th>
    
    
    </tr>
<c:forEach items="${sessionScope.products}" var="p">   
 <tr>
 <td id="d1">${p.pid}</td>
 <td id="d2">${p.pname}</td>
 <td id="d3">${p.cost}</td>
 <td id="d4">${p.quantity}</td>
 <td style="color:#541115;"><a href="addproducts?pid=${p.pid}">Edit</a></td>
 <td style="color:#541115;"><a href="delete?pid=${p.pid}">Delete</a></td>
 </tr>
 </c:forEach>
 
</table>
<br/>
<br/>
<div style="width:20%;border-radius:5px; margin-left:50%;"><a id="ab" style="text-dec"  href="addproduct.jsp">Add</a></div>
</body>
</html>