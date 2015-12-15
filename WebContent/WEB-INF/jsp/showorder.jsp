<%@ page import="com.model.Order" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Order Details</h2>
<p>Order ID: ${orderId}</p>
<br/>
Total: ${order.size()}
<br/>

<table border="1">
<th>Date</th><th>Certificate Number</th><th>Order ID</th><th>Name</th><th>Email</th><th>Value</th><th>Retailer</th>
<c:forEach items="${order}" var="temp">
    <tr>
        <tr>
	<td>${temp.issuedate}</td>
	<td>${temp.gcid}</td>
	<c:set var="gcid" value="${temp.gcid}"/>
	<td>${orderId}</td>
	<td></td>
	<td>${temp.email}</td>
	<td>${temp.denomination}</td>
	<td>${temp.company}</td>
    </tr>
</c:forEach>
</table>

<br><br><br><br>
<p>Enter your new email here:</p>
<form action="showorder.html" method="post">
	<input type="hidden" name="gcid" value="${gcid}">
	<input type="hidden" name="orderId" value="${orderId}">
	<input type="text" name="newEmail">
	<br><br>
	<input type="submit" value="Update Email">
</form>
</body>
</html>