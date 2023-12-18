package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TablaMultiplicar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//construir la tabla del multiplicar del 1 al 10
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");//esto lo que hace es generar una cabecera de respuesta que le dice al navegador que se le va a enviar
	PrintWriter out=response.getWriter();//esto lo que hace es quue podamos escribir en la respuesta
	out.println("<html><body><table border='1'");
	out.println("<tr>");
	//primero lanzamos las cabeceras
	for (int i = 1; i <= 10; i++) {
		out.println("<th>"+i+"</th>");	
	}
	out.println("</tr>");
	//ahora el resto  de las filas
	for (int i = 1; i <=10; i++) {
		out.println("<tr>");
		for (int j = 1; j <=10; j++) {
			out.println("<td> "+i*j+" </td>");				
		}
		out.println("<tr>");	
	}
	out.println("</table></body></html>");
	out.close();
	}	
}
