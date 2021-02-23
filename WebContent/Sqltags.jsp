<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
table{
       border:2px solid skyblue;
     //  color:green;
      // font-family:ardena;
       //font-style:bolder;
    
    }



</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<s:setDataSource driver="oracle.jdbc.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe"  user="java166sqlsagar" password="sagar" var="db"/>

<c:set value="988" var="pid"/>
<c:set value="bottle" var="pname"/>
<c:set value="98" var="cost"/>
<c:set value="9" var="quantity"/>
<s:transaction dataSource="${db}">
<s:update >
 insert into product values(?,?,?,?)
 <s:param value="${pid}"></s:param>
 <s:param value="${pname}"></s:param>
 <s:param value="${cost}"></s:param>
 <s:param value="${quantity}"></s:param>
 
 </s:update >
  <s:update >
   update product set quantity=6  where pid=988
   </s:update>
   </s:transaction>
<s:query var="rs" dataSource="${db}">
 select * from product
</s:query>

<table border='1'>
<tr> <th>Product ID</th><th>Product Name</th><th>Cost</th><th>Quantity</th></tr>
<c:forEach var="pd" items="${rs.rows}">
<tr>
<td>${pd.pid}</td>
<td>${pd.pname}</td>
<td>${pd.cost}</td>
<td>${pd.quantity}</td>

</tr> 
</c:forEach>
</table>


</body>
</html>