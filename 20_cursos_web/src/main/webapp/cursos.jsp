<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.Curso, java.util.List, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<center>
	<h1>Cursos por ordenados cuyo precio maximo es <%=request.getParameter("precio") %></h1>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Duracion </th>
			<th>Precio</th>
		</tr>
		<%List<Curso> listaCurso=(ArrayList<Curso>)request.getAttribute("listaCursos");
		
		for(Curso curso: listaCurso){%>
		<tr>
			<td><%=curso.getNombre() %></td>
			<td><%=curso.getDuracion() %></td>
			<td><%=curso.getPrecio() %></td>
			
		</tr>
	<%} %>
	
	
	</table>
		<p><a href="menu.html">Volver</a></p>
	
</center>


</body>
</html>