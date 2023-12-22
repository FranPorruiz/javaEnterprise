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
		<!-- igual en los atributos de peticion tienes el request, aqui tienes el session -->
		<h1>Has entrado <%=session.getAttribute("contador") %>  veces</h1>
		<br>
		<!-- el application es una variable para poder llamar  -->
		<h2>Numero de total de visitas a mi página:<%=application.getAttribute("global") %></h2>
		<a href="inicio.html">Volver</a>
	</center>

</body>
</html>