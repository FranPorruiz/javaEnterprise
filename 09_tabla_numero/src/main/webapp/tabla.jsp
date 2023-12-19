<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
	table{
		border:1px solid;
		border-collapse: collapse;
		}
	td{
		border: 1px solid ;
		padding: 5px;
		text-align: center;
		}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%int num=Integer.parseInt(request.getParameter("numero")); %>
	<h1>Tabla del <%=num%></h1>
	<table border="1>">
		<%for(int i=1; i<=10;i++) {%>
			<tr>
				<td><%=i%>x<%=num%></td>
				<td><%=i*num%></td>	
			</tr>
		<%}%>
	</table>
</body>
</html>