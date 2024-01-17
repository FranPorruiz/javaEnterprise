<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.Producto, java.util.List, java.util.ArrayList"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrito</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<!-- Esto lanza a un servlet para cerrar la sessión -->
<div class="container">
	<a href="CerrarSesionServlet">Cerrar Sesion</a>
		<!-- Esta etiqueta de jstl lo que nos hace es preguntarnos si el contenido  
		 de la session que corresponde a carrito-->
		<c:if test="${!empty sessionScope.listaProducto}">
		<table class="table-success">
			<tr>
				<th>Nombre</th>
				<th>Precio </th>
				<th>Cantidad</th>
				<th></th>	
			</tr>
			<%-- 
			<%List<Producto> listaProducto=new ArrayList<Producto>();
			if(session.getAttribute("listaProducto")!=null) {
				listaProducto=(List<Producto>)session.getAttribute("listaProducto");
			}
			for(Producto producto: listaProducto) {%>
			<tr>
				<td><%=producto.getNombre() %></td>
				<td><%=producto.getPrecio() %></td>
				<td><%=producto.getCategoria() %></td>
				<td>
					<!-- con esta linea le decimos que le pasa el parametro nombre al Servlet y le decimos a que corresponda -->
					<a href="BorrarServlet?nombre=<%=producto.getNombre()%>">Eliminar</a></td>		
			</tr>
			<%}%>
			--%>
			<%--El mismo codigo que antes usando EL y JSTL --%>
			<c:forEach var="pr" items="${sessionScope.listaProducto}">
				<tr>
					<td>${pr.nombre}</td>
					<td>${pr.precio}</td>
					<td>${pr.categoria}</td>
			
				</tr>
			</c:forEach>
		</table>
		</c:if>
		<p><a href="Inicio.html">Volver</a></p>
</div>		
</body>
</html>