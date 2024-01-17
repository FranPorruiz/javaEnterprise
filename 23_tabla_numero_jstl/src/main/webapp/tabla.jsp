<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div  class="mx-auto" style="width: 400px;">
		<!-- recibe el value numero del input type del formularo numeroHTML -->
		<h2>Tabla del ${param.numero}</h1>

		<table class="table table-bordered table-striped">
			<c:forEach var="i" begin="1" end="10" step="1">
				<tr>
					<td>${i} x ${param.numero }</td>
					<td>${i*param.numero}</td>
				</tr>
			</c:forEach>
			
		</table>
	</div>
</body>
</html>