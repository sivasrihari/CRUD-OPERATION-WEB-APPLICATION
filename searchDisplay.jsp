<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored='false'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor='green'>
<center>
	<c:choose>
	
		
		<c:when test='${student ne null||!empty student}'> <table  bgcolor='cyan'><tr><th>ID</th><td>${student.sid}</td></tr>
		<tr><th>NAME</th><td>${student.sname}</td></tr>
		<tr><th>AGE</th><td>${student.sage}</td></tr>
		<tr><th>ADDREDD</th><td>${student.saddress}</td></tr>
		</table></c:when>
		
		<c:otherwise>
			<h1 style='color:red:text-align:center'>NO recored to display</h1>
		</c:otherwise>
	</c:choose>
	</center>
</body>
</html>