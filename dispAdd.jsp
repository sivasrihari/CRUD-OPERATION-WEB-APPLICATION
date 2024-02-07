<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored='false'%>
 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ADDING RESULT</title>
</head>
<body  bgcolor='green'>
<center>
	<!--<c:set var='x' value='${msg}'/>
		<c:out value='${x}'/>-->
	<c:choose>
	
		<c:when test='${request.msg eq SUCCESS}'><h1 style='color:green:text align:center'>ADDING IS SUCCESSFULL</h1></c:when>
		<c:otherwise><h1 style='color:red:text align:center'>ADDING IS FAILED</h1></c:otherwise>
	</c:choose>
	
</center>
</body>
</center></html>