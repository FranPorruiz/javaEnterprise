<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<center>
	<%
		for(int i=1;i<=6;i++){%>
		<!-- Lo que estamos haciendo son cabeceras que se hacen m�s grandes -->
		<h<%=i%>>Primera JSP</h<%=i %>>
		<%}%>
	</center>
</body>
</html>