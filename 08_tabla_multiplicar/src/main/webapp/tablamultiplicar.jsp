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
	<!-- Tabla de multiplicar de 10 x 10 -->
	<table >
	<%for(int i=1; i<=10;i++){%>
			<tr>
				<%for(int j=1; j<=10;j++){%>
					<td><%=i%>X<%=j%>=<%=i*j%></td>
				<%}%>
			</tr>	
	<%}%>
	</table>
</body>
</html>