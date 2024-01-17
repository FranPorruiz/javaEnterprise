<%@page import="model.Producto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.Producto, java.util.List"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"></head>
<body>
	<div class="mx-auto" style="width: 600px;">
	<h2>Productos de ${param.categoria}  </h2>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Precio</th>
		</tr>
		<c:forEach var="pr" items="${requestScope.resultados}">
				<tr>
					<td>${pr.nombre}</td>
					<td>${pr.precio}</td>			
				</tr>
			</c:forEach>
	</table>
	<a href="Home.html">Volver a home</a>
	</div>
</body>
</html>