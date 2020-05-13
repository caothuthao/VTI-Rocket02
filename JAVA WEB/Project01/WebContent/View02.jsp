<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="tempStudent" items="${listStudents}">
		First Name: ${tempStudent.getFirstName()} <br>
		Last Name: ${tempStudent.getLastName()} <br>
		Email: ${tempStudent.getEmail()} <br>
	</c:forEach>
</body>
</html>