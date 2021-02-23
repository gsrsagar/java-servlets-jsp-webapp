<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <c:set var="date" value="<%=new java.util.Date() %>"/>
 <h1>Formatting Date</h1>
 <fm:formatDate value="${date}" type="both"/><br/>
 <fm:formatDate  value="${date}" type="date" dateStyle="Long"/><br/>
 <fm:formatDate value="${date}" type="time" timeStyle="Long"/><br/>
 <fm:formatDate value="${date}" type="date" pattern="MMM/dd/yyyy"/>
 
 

</body>
</html>