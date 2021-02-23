<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Products</title>

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
    th{
       color:white;
        font-family:calibri;
    }
    #d1,#d3{
        color:white;
        border-bottom:1px solid #541115;
       
       }
       #d2,#d4{
       color:white;
       border-bottom:1px solid #541115;
       }
    td{ 
     width:18%;
   // background-color:green;
    padding:10px;
    font-family:calibri;
    }
    #ab{  
             
        background-color:grey;
        border:1px solid white;
        border-radius:5px;
        color:black;
    }
  </style>
  </head>
<body>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="menu.html"%>
<b><span style="font-family:calibri;">Logged in as ${sessionScope.sname}</span></b>
<table>
    <tr>
    <th>Pid</th>
    <th>Pname</th>
    <th>Cost</th>
    <th>Quantity</th>
    <th colspan='2'>Buy a Product</th>
    <th colspan='2'></th>
    </tr>
<c:forEach items="${sessionScope.products1}" var="p1">   
 <tr>
 <td id="d1">${p1.pid}</td>
 <td id="d2">${p1.pname}</td>
 <td id="d3">${p1.cost}</td>
 <td id="d4">${p1.quantity}</td>
 <td id="ab"><a href="buyproducts?pid=${p1.pid}">Buy Product</a></td>
 </tr>
 </c:forEach>
 
</table>


</body>
</html>