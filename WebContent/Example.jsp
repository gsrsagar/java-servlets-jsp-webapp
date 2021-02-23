<%@page import="com.mphasis.cart.bo.CartAUserBo" %>
<%@page import="com.mphasis.cart.bo.CartAUserBoImp" %>
<%@page import="com.mphasis.training.amazonjdbcprograms.CartAUser" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! CartAUserBo cartAUserBo=new CartAUserBoImp(); %>
<% String name=request.getParameter("uname");
  CartAUser user= cartAUserBo.login(name,request.getParameter("pwd"));
try{
session.setAttribute("sname",name);
out.print("welcome"+name);
pageContext.setAttribute("sname", name,PageContext.APPLICATION_SCOPE);
%>
<%@include file="menu.html"%>
<% }catch(Exception e){ e.printStackTrace(); %>
<jsp:forward page="login.html"></jsp:forward>
<%} %>
<br/>
<%= new java.util.Date() %>

</body>
</html>