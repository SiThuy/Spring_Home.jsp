<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<p>
			<label>Number a</label> <input type="number" name="a">
		</p>
		<p>
			<label>Number b</label> <input type="number" name="b">
		</p>
		<p>
			<button>Sum</button>
		</p>
	</form>
	<c:if test="${result != null}">
		<p>${a}+ ${b} = ${result}</p>
	</c:if>
</body>
</html>