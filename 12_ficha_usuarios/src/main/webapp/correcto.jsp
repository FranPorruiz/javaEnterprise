<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.Ficha"%>
<%--Comentario en JSP  arriba hemos hecho una importacion del model Ficha--%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- Aqui reccogemos los datos que el servlet le ha enviado 
		Tenemos que hacer un casting porque lo recibimos como onbjeto--%>
	
	<%Ficha ficha=(Ficha)request.getAttribute("ficha"); %>
	<p><%=request.getParameter("usuario")%>es valido<p>
	<p>Nombre: <%=ficha.getUsuario() %></p>
	<p>Edad: <%=ficha.getEdad() %></p>
	<p>Correo: <%=ficha.getEmail() %></p>
	<br>
	<a href="login.html">Volver al inicio</a>
	
	

</body>
</html>