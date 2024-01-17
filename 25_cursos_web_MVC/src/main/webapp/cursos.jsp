<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.Curso, java.util.List, java.util.ArrayList"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- las siguientes etiquetas meta sirven para que el navegador
no cachee la página
-->
<meta http-equiv="Expires" content="0">
<meta http-equiv="Last-Modified" content="0">
<meta http-equiv="Cache-Control" content="no-cache, mustrevalidate">
<meta http-equiv="Pragma" content="no-cache">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
	<div class="border  align-items-center justify-content-center">
		<h1>Cursos por ordenados cuyo precio maximo es ${param.precio} </h1>
		<table>
			<tr>
				<th>Nombre</th>
				<th>Duracion </th>
				<th>Precio</th>
			</tr>
			<c:forEach var="cu" items="${requestScope.listaCursos}">
				<tr>
					<td>${cu.nombre}</td>
					<td>${cu.duracion}</td>			
					<td>${cu.precio}</td>			
				</tr>
			</c:forEach>
		</table>
			<p><a href="FrontController?operation=toInicio">Volver</a></p>
	</div>


</body>
</html>