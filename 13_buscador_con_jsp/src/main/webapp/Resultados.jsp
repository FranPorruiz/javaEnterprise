<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="model.Pagina, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%List<Pagina> listPaginas=(List<Pagina>)request.getAttribute("resultados"); %>
	<%for (Pagina pagina : listPaginas) { %>
		<p><%=pagina.getUrl()%></p><br>
		<p><%=pagina.getDescripcion() %></p>

	<%} %>
</body>
</html>