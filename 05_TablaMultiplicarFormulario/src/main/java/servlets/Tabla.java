package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Tabla extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=Integer.parseInt(request.getParameter("numero"));
		response.setContentType("text/html");//esto lo que hace es generar una cabecera de respuesta que le dice al navegador que se le va a enviar
		PrintWriter out=response.getWriter();//esto lo que hace es quue podamos escribir en la respuesta
		out.println("<html><body><table border='1'");
		for (int i = 1; i <=10; i++) {
			out.println("<tr>");
				out.println("<td>"+i+" x "+num+"</td>");
				out.println("<td>"+i*num+"</td>");
			out.println("<tr>");	
		}
		out.println("</table>");
		out.println("<a href='NumeroHTML.html'>Volver</a>");
		out.println("</body></html>");
		out.close();
	}
}
