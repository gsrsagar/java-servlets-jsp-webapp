<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <h1> Formatting number</h1>
 <c:set value="84596.345" var="salary"/>
 <fm:formatNumber value="${salary}" type="currency"></fm:formatNumber><br/><br/>
 <fm:formatNumber value="${salary}" type="number" groupingUsed="false"></fm:formatNumber><br/><br/>
 <fm:formatNumber value="${salary}" type="percent"></fm:formatNumber> <br/><br/>
 <fm:formatNumber value="${salary}" type="number" maxIntegerDigits="4"></fm:formatNumber> <br/><br/>
 <fm:formatNumber value="${salary}" type="currency" currencyCode="USD"></fm:formatNumber> <br/><br/>
 
 
 
</body>
</html>