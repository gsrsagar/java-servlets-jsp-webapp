<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
  
         
    <c:set var="employees">  
       <employees>
      <employee>  
         <eid> 456</eid>
      <ename>Sagar</ename>
      <salary>500000</salary>
      </employee>
      
      <employee>
         <eid> 457</eid>
      <ename>Chandana</ename>
      <salary>50000</salary>
      </employee>
      
      <employee>
         <eid> 458</eid>
      <ename>Priyanka</ename>
      <salary>5000000</salary>
      </employee>
      </employees>
  </c:set>
  <x:parse xml="${employees}" var="emps"/>
     
  <x:choose><x:when select="$emps//employee/ename='Sagar'">sagar is a good employee</x:when>
    
    
    <x:when select="$emps//employee/ename='priyanka'">Priyanka is a good girl</x:when>
    <x:otherwise> not available</x:otherwise>
    </x:choose>
<ul>
<x:forEach select="$emps//employee/ename" var="n">
 <li><x:out select="$n"/></li>
 </x:forEach>
 </ul>




</body>
</html>