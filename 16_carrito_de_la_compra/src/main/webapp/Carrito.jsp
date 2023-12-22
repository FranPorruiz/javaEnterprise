<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.Producto, java.util.List, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrito</title>
</head>
<body>
<!-- Esto lanza a un servlet para cerrar la sessión -->
<a href="CerrarSesionServlet">Cerrar Sesion</a>
	<table>
		<tr>
			<th>Nombre</th>
			<th>Precio </th>
			<th>Cantidad</th>
			<th></th>	
		</tr>
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
	
	</table>
	<p><a href="Inicio.html">Volver</a></p>
</body>
</html>