<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored='false'%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test='${request.msg eq success}'><h1 style='color:green;text-align:center'>data deleted successfully</h1></c:when>
		<c:otherwise><h1 style='color:green;text-align:center'>data not deleted for given input</h1></c:otherwise>
	</c:choose>
</body>
</html>